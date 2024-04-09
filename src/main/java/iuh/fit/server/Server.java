/**
 * 
 */
package iuh.fit.server;

import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import iuh.fit.dao.CourseDAO;
import iuh.fit.dao.StudentDAO;
import iuh.fit.dao.impl.CourseDAOImpl;
import iuh.fit.dao.impl.StudentDAOImpl;
import iuh.fit.entity.Course;
import iuh.fit.entity.Student;
import iuh.fit.entity.StudentGrade;

/**
 * @author Trần Nguyên Vũ
 * @version 1.0
 * @created 2 Apr 2024 - 2:36:25 pm
 */
public class Server {
	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(8201)) {
			System.out.println("Server is running on port 8201");

			while (true) {
				System.out.println("Server: Waiting for client");
				Socket socket = server.accept();
				Server temp = new Server();

				System.out.println("Server: Client " + socket.getLocalAddress().getHostName() + " connected");

				new Thread(temp.new Handler(socket)).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private class Handler implements Runnable {
		private Socket socket;
		private CourseDAO courseDAO;
		private StudentDAO studentDAO;

		public Handler(Socket socket) {
			this.socket = socket;
			this.courseDAO = new CourseDAOImpl();
			this.studentDAO = new StudentDAOImpl();
		}

		@Override
		public void run() {
			try {
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				int choice;
				while (true) {
					choice = dis.readInt();
					System.out.println("Server: Choice: " + choice);

					switch (choice) {
					case 1:
						// Get all courses
						System.out.println("Server: Get all courses");
						List<Course> courses = courseDAO.getAllCourses();
						oos.writeObject(courses);
						oos.flush();
						break;
					case 2:
						// Get course by ID
						System.out.println("Server: Get course by ID");
						int id = dis.readInt();
						System.out.println("Server: ID: " + id);
						Course courseById = courseDAO.getCourseById(id);
						oos.writeObject(courseById);
						oos.flush();
						break;
					case 3:
						// Get course by name
						System.out.println("Server: Get course by name");
						String title = dis.readUTF();
						System.out.println("Server: Name: " + title);
						Course course = courseDAO.getCourseByName(title);
						oos.writeObject(course);
						oos.flush();
						break;
					case 4:
						System.out.println("Server: Get all students");
						List<Student> students = studentDAO.getAllStudents();
						oos.writeObject(students);
						oos.flush();
						break;
					case 5:
						System.out.println("Server: Get a student's grades by student ID");
						int studentId = dis.readInt();
						System.out.println("Server: Student ID: " + studentId);
						List<StudentGrade> grades = studentDAO.getStudentCourseGradesByID(studentId);
						oos.writeObject(grades);
						oos.flush();
						break;
					default:
						System.out.println("Invalid choice");
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
