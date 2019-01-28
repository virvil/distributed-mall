package distributed.mall.common.utils;

import java.util.UUID;

/**
 * 默认的ID生成器
 */
public class DefaultIdGenerator {
	public static String createId() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
