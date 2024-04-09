/**
 * 
 */
package iuh.fit.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Trần Nguyên Vũ
 * @version 1.0
 * @created 9 Apr 2024 - 12:23:30 am
 */
public class AppUtils {
	public static <T> List<T> castList(Collection<?> c, Class<? extends T> clazz) {
		List<T> r = new ArrayList<T>(c.size());
		for (Object o : c)
			r.add(clazz.cast(o));
		return r;
	}
}
