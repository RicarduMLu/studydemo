package utils;

import constants.DatePatterns;
import constants.Strings;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

/**
 * @author Jianguo Luo
 * @date 2021/4/4
 * @Description 日期与时间工具类
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TimeUtil {
    public static final String TIMEZONE_NAME = "Asia/Shanghai";
    public static final ZoneId TIMEZONE = ZoneId.of(TIMEZONE_NAME);
    public static final long MILS_PER_SECOND = 1000L;
    public static final long MILS_PER_MINUTE = 60 * MILS_PER_SECOND;
    public static final long MILS_PER_HOUR = 60 * MILS_PER_MINUTE;
    public static final long MILS_PER_DAY = 24 * MILS_PER_HOUR;

    /**
     * 判断两个时间是不是属于同一天，如果是返回true，否则返回false
     */
    public static boolean isSameDay(Date start, Date end) {
        return toZoneDateTime(start).toLocalDate().isEqual(toZoneDateTime(end).toLocalDate());
    }

    /**
     * 判断两个时间是不是属于同一天，如果是返回true，否则返回false
     */
    public static boolean isSameDay(LocalDateTime start, LocalDateTime end) {
        return start.toLocalDate().isEqual(end.toLocalDate());
    }

    /**
     * 判断两个时间是不是属于同一天，如果是返回true，否则返回false
     */
    public static boolean isSameDay(LocalDate start, LocalDate end) {
        return start.isEqual(end);
    }

    /**
     * 将Date对象格式为字符串
     */
    public static String format(Date date, String pattern) {
        ZonedDateTime zonedDateTime = toZonedDateTime(date);
        return DateTimeFormatter.ofPattern(pattern).format(zonedDateTime);
    }

    /**
     * 将LocalDateTime对象格式为字符串
     */
    public static String format(LocalDateTime localDateTime, String pattern) {
        return format(toDate(localDateTime), pattern);
    }

    /**
     * 将LocalDate对象格式为字符串
     */
    public static String format(LocalDate localDate, String pattern) {
        return format(toDate(localDate), pattern);
    }

    /**
     * 采用指定的pattern将日期字符串转化为Date对象
     */
    public static Date parseDate(String date, String pattern) {
        try {
            return new SimpleDateFormat(pattern, Locale.CHINESE).parse(date);
        } catch (ParseException e) {
            log.error("parse date '{}' error", date, e);
            return null;
        }
    }

    /**
     * 采用指定的pattern将日期字符串转化为LocalDateTime对象
     */
    public static LocalDateTime parseLocalDateTime(String date, String pattern) {
        return toLocalDateTime(parseDate(date, pattern));
    }

    /**
     * 采用指定的pattern将日期字符串转化为LocalDate对象
     */
    public static LocalDate parseLocalDate(String date, String pattern) {
        return toLocalDate(parseDate(date, pattern));
    }

    /**
     * 获取当前天的开始时间
     */
    public static Date getStartOfDay(Date date) {
        ZonedDateTime zonedDateTime = toZonedDateTime(date);
        return toDate(zonedDateTime.truncatedTo(ChronoUnit.DAYS));
    }

    /**
     * 获取当前天的开始时间
     */
    public static LocalDateTime getStartOfDay(LocalDateTime localDateTime) {
        return localDateTime.truncatedTo(ChronoUnit.DAYS);
    }

    /**
     * 获取当前月的开始时间
     */
    public static Date getStartOfMonth(Date date) {
        ZonedDateTime zonedDateTime = toZonedDateTime(date);
        zonedDateTime.withDayOfMonth(1);
        return toDate(zonedDateTime);
    }

    /**
     * 获取当前月的开始时间
     */
    public static LocalDateTime getStartOfMonth(LocalDateTime localDateTime) {
        return localDateTime.withDayOfMonth(1);
    }

    /**
     * 获取当前月的开始时间
     */
    public static LocalDate getStartOfMonth(LocalDate localDate) {
        return localDate.withDayOfMonth(1);
    }

    /**
     * 获取当前年的开始时间
     */
    public static Date getStartOfYear(Date date) {
        ZonedDateTime zonedDateTime = toZonedDateTime(date);
        return toDate(zonedDateTime.withMonth(1).withDayOfMonth(1));
    }

    /**
     * 获取当前年的开始时间
     */
    public static LocalDate getStartOfYear(LocalDate localDate) {
        return localDate.withMonth(1).withDayOfMonth(1);
    }

    /**
     * 获取当前年的开始时间
     */
    public static LocalDateTime getStartOfYear(LocalDateTime localDateTime) {
        return localDateTime.withMonth(1).withDayOfMonth(1);
    }

    /**
     * 计算今天是星期几
     */
    public DayOfWeek getWeek(Date date) {
        return toZonedDateTime(date).getDayOfWeek();
    }

    /**
     * 计算当前星期处在当前月的第几个星期
     */
    public int getWeekIndex(Date date) {
        DayOfWeek dayOfWeek = toZonedDateTime(date).getDayOfWeek();
        DayOfWeek[] values = DayOfWeek.values();
        for (int i = 0; i < values.length; i++) {
            if (values[i] == dayOfWeek) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 计算当前星期处在当前月的第几个星期
     */
    public int getWeekIndex(LocalDate localDate) {
        return getWeekIndex(toDate(localDate));
    }

    /**
     * 计算当前星期处在当前月的第几个星期
     */
    public int getWeekIndex(LocalDateTime localDateTime) {
        return getWeekIndex(toDate(localDateTime));
    }

    /**
     * 获取明天的当前时间
     */
    public static Date tomorrow(Date now) {
        return addTime(now, 1, ChronoUnit.DAYS);
    }

    /**
     * 获取明天的当前时间
     */
    public static LocalDate tomorrow(LocalDate localDate) {
        return addTime(localDate, 1, ChronoUnit.DAYS);
    }

    /**
     * 获取明天的当前时间
     */
    public static LocalDateTime tomorrow(LocalDateTime localDate) {
        return addTime(localDate, 1, ChronoUnit.DAYS);
    }

    /**
     * 获取下个月的当前时间
     */
    public static Date nextMonth(Date now) {
        return addTime(now, 1, ChronoUnit.MONTHS);
    }

    /**
     * 获取下个月的当前时间
     */
    public static LocalDateTime nextMonth(LocalDateTime now) {
        return addTime(now, 1, ChronoUnit.MONTHS);
    }

    /**
     * 获取下个月的当前时间
     */
    public static LocalDate nextMonth(LocalDate now) {
        return addTime(now, 1, ChronoUnit.MONTHS);
    }

    /**
     * 按指定单位增加（或减少）时间值
     */
    public static Date addTime(Date date, long delta, ChronoUnit unit) {
        return add(date, delta, unit);
    }

    /**
     * 按指定单位增加（或减少）时间值
     */
    public static LocalDate addTime(LocalDate date, long delta, ChronoUnit unit) {
        return add(date, delta, unit);
    }

    /**
     * 按指定单位增加（或减少）时间值
     */
    public static LocalDateTime addTime(LocalDateTime date, long delta, ChronoUnit unit) {
        return add(date, delta, unit);
    }

    private static Date add(Date date, long delta, ChronoUnit chronoUnit) {
        LocalDateTime localDateTime = toLocalDateTime(date);
        return toDate(localDateTime.plus(delta, chronoUnit));
    }

    private static LocalDateTime add(LocalDateTime date, long delta, ChronoUnit chronoUnit) {
        return date.plus(delta, chronoUnit);
    }

    private static LocalDate add(LocalDate date, long delta, ChronoUnit chronoUnit) {
        return date.plus(delta, chronoUnit);
    }

    /**
     * 获取yyyy-MM-dd格式时间字符串
     */
    public static String getDateStr(LocalDateTime date) {
        return format(toDate(date), DatePatterns.YYYY_MM_DD);
    }

    /**
     * 获取yyyy-MM-dd格式时间字符串
     */
    public static String getDateStr(LocalDate date) {
        return format(toDate(date), DatePatterns.YYYY_MM_DD);
    }

    /**
     * 获取yyyy-MM-dd格式时间字符串
     */
    public static String getDateStr(Date date) {
        if (date == null) {
            return Strings.EMPTY;
        }
        return format(date, DatePatterns.YYYY_MM_DD);
    }

    /**
     * 获取年份，比1990-11-22 10:33:44中，获取到的值为：1990
     */
    public static String getYear(Date date) {
        if (date == null) {
            return Strings.EMPTY;
        }
        return String.valueOf(toLocalDateTime(date).getYear());
    }

    /**
     * 获取年份，比1990-11-22 10:33:44中，获取到的值为：1990
     */
    public static String getYear(LocalDateTime date) {
        return getYear(toDate(date));
    }

    /**
     * 获取年份，比1990-11-22中，获取到的值为：1990
     */
    public static String getYear(LocalDate date) {
        return getYear(toDate(date));
    }

    /**
     * 获取月份，比1990-11-22 10:33:44中，获取到的值为：11
     */
    public static String getMonth(Date date) {
        if (date == null) {
            return Strings.EMPTY;
        }
        return String.valueOf(toLocalDateTime(date).getMonth().getValue());
    }

    /**
     * 获取月份，比1990-11-22 10:33:44中，获取到的值为：11
     */
    public static String getMonth(LocalDateTime date) {
        return getMonth(toDate(date));
    }

    /**
     * 获取月份，比1990-11-22中，获取到的值为：11
     */
    public static String getMonth(LocalDate date) {
        return getMonth(toDate(date));
    }

    /**
     * 获取日期，比1990-11-22 10:33:44中，获取到的值为：22
     */
    public static String getDayOfMonth(Date date) {
        if (date == null) {
            return Strings.EMPTY;
        }
        return String.valueOf(toLocalDateTime(date).getDayOfMonth());
    }

    /**
     * 获取日期，比1990-11-22 10:33:44中，获取到的值为：22
     */
    public static String getDayOfMonth(LocalDateTime date) {
        return getDayOfMonth(toDate(date));
    }

    /**
     * 获取日期，比1990-11-22中，获取到的值为：22
     */
    public static String getDayOfMonth(LocalDate date) {
        return getDayOfMonth(toDate(date));
    }

    public static ZonedDateTime toZoneDateTime(Date date) {
        return ZonedDateTime.ofInstant(date.toInstant(), TIMEZONE);
    }

    public static ZonedDateTime toZonedDateTime(Date date) {
        return ZonedDateTime.ofInstant(date.toInstant(), TIMEZONE);
    }

    public static LocalDateTime toLocalDateTime(Date date) {
        ZonedDateTime zonedDateTime = toZonedDateTime(date);
        return zonedDateTime.toLocalDateTime();
    }

    public static LocalDate toLocalDate(Date date) {
        ZonedDateTime zonedDateTime = toZonedDateTime(date);
        return zonedDateTime.toLocalDate();
    }

    public static LocalTime toLocalTime(Date date) {
        ZonedDateTime zonedDateTime = toZonedDateTime(date);
        return LocalTime.of(zonedDateTime.getHour(), zonedDateTime.getMinute(), zonedDateTime.getSecond());
    }

    public static Date toDate(ZonedDateTime zonedDateTime) {
        return Date.from(zonedDateTime.toInstant());
    }

    public static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(TIMEZONE).toInstant());
    }

    public static Date toDate(LocalDate localDate) {
        return Date.from(localDate.atTime(LocalTime.of(0, 0, 0)).atZone(TIMEZONE).toInstant());
    }

    public static Date timeAtToday(LocalTime localTime) {
        return toDate(LocalDate.now(), localTime);
    }

    public static Date toDate(Date dt, LocalTime localTime) {
        return toDate(toLocalDate(dt), localTime);
    }

    public static Date toDate(LocalDate localDate, LocalTime localTime) {
        return Date.from(localTime.atDate(localDate).atZone(TIMEZONE).toInstant());
    }

    /**
     * 判断两个时间区间是否存在交集
     *
     * @param currentStart 当前区间-开始时间
     * @param currentEnd   当前区间-结束时间
     * @param compareStart 对比区间-开始时间
     * @param compareEnd   对比区间-结束时间
     * @return 存在交集返回true， 否则返回false
     */
    public static boolean existOverlaps(Date currentStart, Date currentEnd, Date compareStart, Date compareEnd) {
        return currentEnd.getTime() > compareStart.getTime() && currentStart.getTime() < compareEnd.getTime();
    }

    /**
     * 判断两个时间区间是否存在交集
     *
     * @param currentStart 当前区间-开始时间
     * @param currentEnd   当前区间-结束时间
     * @param compareStart 对比区间-开始时间
     * @param compareEnd   对比区间-结束时间
     * @return 存在交集返回true， 否则返回false
     */
    public static boolean existOverlaps(LocalDateTime currentStart, LocalDateTime currentEnd, LocalDateTime compareStart, LocalDateTime compareEnd) {
        return existOverlaps(toDate(currentStart), toDate(currentEnd), toDate(compareStart), toDate(compareEnd));
    }

    /**
     * 判断两个时间区间是否存在交集
     *
     * @param currentStart 当前区间-开始时间
     * @param currentEnd   当前区间-结束时间
     * @param compareStart 对比区间-开始时间
     * @param compareEnd   对比区间-结束时间
     * @return 存在交集返回true， 否则返回false
     */
    public static boolean existOverlaps(LocalDate currentStart, LocalDate currentEnd, LocalDate compareStart, LocalDate compareEnd) {
        return existOverlaps(toDate(currentStart), toDate(currentEnd), toDate(compareStart), toDate(compareEnd));
    }

    /**
     * 计算两个时间区间交集的天数
     *
     * @param currentStart 当前区间-开始时间
     * @param currentEnd   当前区间-结束时间
     * @param compareStart 对比区间-开始时间
     * @param compareEnd   对比区间-结束时间
     * @return 交集的天数（向上取整：超过的部分不足1天也按1天计算）
     */
    public static long overlapDaysWithCeil(Date currentStart, Date currentEnd, Date compareStart, Date compareEnd) {
        long overlapMils = overlapMils(currentStart, currentEnd, compareStart, compareEnd);
        return overlapMils % MILS_PER_DAY == 0 ? overlapMils / MILS_PER_DAY : overlapMils / MILS_PER_DAY + 1;
    }

    /**
     * 计算两个时间区间交集的天数
     *
     * @param currentStart 当前区间-开始时间
     * @param currentEnd   当前区间-结束时间
     * @param compareStart 对比区间-开始时间
     * @param compareEnd   对比区间-结束时间
     * @return 交集的天数（向上取整：超过的部分不足1天也按1天计算）
     */
    public static long overlapDaysWithCeil(LocalDateTime currentStart, LocalDateTime currentEnd, LocalDateTime compareStart, LocalDateTime compareEnd) {
        return overlapDaysWithCeil(toDate(currentStart), toDate(currentEnd), toDate(compareStart), toDate(compareEnd));
    }

    /**
     * 计算两个时间区间交集的天数
     *
     * @param currentStart 当前区间-开始时间
     * @param currentEnd   当前区间-结束时间
     * @param compareStart 对比区间-开始时间
     * @param compareEnd   对比区间-结束时间
     * @return 交集的天数（向上取整：超过的部分不足1天也按1天计算）
     */
    public static long overlapDaysWithCeil(LocalDate currentStart, LocalDate currentEnd, LocalDate compareStart, LocalDate compareEnd) {
        return overlapDaysWithCeil(toDate(currentStart), toDate(currentEnd), toDate(compareStart), toDate(compareEnd));
    }

    /**
     * 计算两个时间区间交集的天数
     *
     * @param currentStart 当前区间-开始时间
     * @param currentEnd   当前区间-结束时间
     * @param compareStart 对比区间-开始时间
     * @param compareEnd   对比区间-结束时间
     * @return 交集的天数（向下取整：超过部分不足一天的部分舍弃掉）
     */
    public static long overlapDaysWithFloor(Date currentStart, Date currentEnd, Date compareStart, Date compareEnd) {
        long overlapMils = overlapMils(currentStart, currentEnd, compareStart, compareEnd);
        return overlapMils / MILS_PER_DAY;
    }

    /**
     * 计算两个时间区间交集的天数
     *
     * @param currentStart 当前区间-开始时间
     * @param currentEnd   当前区间-结束时间
     * @param compareStart 对比区间-开始时间
     * @param compareEnd   对比区间-结束时间
     * @return 交集的天数（向下取整：超过部分不足一天的部分舍弃掉）
     */
    public static long overlapDaysWithFloor(LocalDateTime currentStart, LocalDateTime currentEnd, LocalDateTime compareStart, LocalDateTime compareEnd) {
        return overlapDaysWithFloor(toDate(currentStart), toDate(currentEnd), toDate(compareStart), toDate(compareEnd));
    }

    /**
     * 计算两个时间区间交集的天数
     *
     * @param currentStart 当前区间-开始时间
     * @param currentEnd   当前区间-结束时间
     * @param compareStart 对比区间-开始时间
     * @param compareEnd   对比区间-结束时间
     * @return 交集的天数（向下取整：超过部分不足一天的部分舍弃掉）
     */
    public static long overlapDaysWithFloor(LocalDate currentStart, LocalDate currentEnd, LocalDate compareStart, LocalDate compareEnd) {
        return overlapDaysWithFloor(toDate(currentStart), toDate(currentEnd), toDate(compareStart), toDate(compareEnd));
    }

    /**
     * 计算两个时间区间交集的小时数
     *
     * @param currentStart 当前区间-开始时间
     * @param currentEnd   当前区间-结束时间
     * @param compareStart 对比区间-开始时间
     * @param compareEnd   对比区间-结束时间
     * @return 交集的小时数（向上取整：超过的部分不足1小时也按1小时计算）
     */
    public static long overlapHoursWithCeil(Date currentStart, Date currentEnd, Date compareStart, Date compareEnd) {
        long overlapMils = overlapMils(currentStart, currentEnd, compareStart, compareEnd);
        return overlapMils % MILS_PER_HOUR == 0 ? overlapMils / MILS_PER_HOUR : overlapMils / MILS_PER_HOUR + 1;
    }

    /**
     * 计算两个时间区间交集的小时数
     *
     * @param currentStart 当前区间-开始时间
     * @param currentEnd   当前区间-结束时间
     * @param compareStart 对比区间-开始时间
     * @param compareEnd   对比区间-结束时间
     * @return 交集的小时数（向上取整：超过的部分不足1小时也按1小时计算）
     */
    public static long overlapHoursWithCeil(LocalDateTime currentStart, LocalDateTime currentEnd, LocalDateTime compareStart, LocalDateTime compareEnd) {
        return overlapHoursWithCeil(toDate(currentStart), toDate(currentEnd), toDate(compareStart), toDate(compareEnd));
    }

    /**
     * 计算两个时间区间交集的小时数
     *
     * @param currentStart 当前区间-开始时间
     * @param currentEnd   当前区间-结束时间
     * @param compareStart 对比区间-开始时间
     * @param compareEnd   对比区间-结束时间
     * @return 交集的小时数（向上取整：超过的部分不足1小时也按1小时计算）
     */
    public static long overlapHoursWithCeil(LocalDate currentStart, LocalDate currentEnd, LocalDate compareStart, LocalDate compareEnd) {
        return overlapHoursWithCeil(toDate(currentStart), toDate(currentEnd), toDate(compareStart), toDate(compareEnd));
    }

    /**
     * 计算两个时间区间交集的小时数
     *
     * @param currentStart 当前区间-开始时间
     * @param currentEnd   当前区间-结束时间
     * @param compareStart 对比区间-开始时间
     * @param compareEnd   对比区间-结束时间
     * @return 交集的小时数（向下取整：超过部分不足一小时的部分舍弃掉）
     */
    public static long overlapHoursWithFloor(Date currentStart, Date currentEnd, Date compareStart, Date compareEnd) {
        long overlapMils = overlapMils(currentStart, currentEnd, compareStart, compareEnd);
        return overlapMils / MILS_PER_HOUR;
    }

    /**
     * 计算两个时间区间交集的小时数
     *
     * @param currentStart 当前区间-开始时间
     * @param currentEnd   当前区间-结束时间
     * @param compareStart 对比区间-开始时间
     * @param compareEnd   对比区间-结束时间
     * @return 交集的小时数（向下取整：超过部分不足一小时的部分舍弃掉）
     */
    public static long overlapHoursWithFloor(LocalDateTime currentStart, LocalDateTime currentEnd, LocalDateTime compareStart, LocalDateTime compareEnd) {
        return overlapHoursWithFloor(toDate(currentStart), toDate(currentEnd), toDate(compareStart), toDate(compareEnd));
    }

    /**
     * 计算两个时间区间交集的小时数
     *
     * @param currentStart 当前区间-开始时间
     * @param currentEnd   当前区间-结束时间
     * @param compareStart 对比区间-开始时间
     * @param compareEnd   对比区间-结束时间
     * @return 交集的小时数（向下取整：超过部分不足一小时的部分舍弃掉）
     */
    public static long overlapHoursWithFloor(LocalDate currentStart, LocalDate currentEnd, LocalDate compareStart, LocalDate compareEnd) {
        return overlapHoursWithFloor(toDate(currentStart), toDate(currentEnd), toDate(compareStart), toDate(compareEnd));
    }

    /**
     * 计算两个时间区间交集的毫秒数
     *
     * @param currentStart 当前区间-开始时间
     * @param currentEnd   当前区间-结束时间
     * @param compareStart 对比区间-开始时间
     * @param compareEnd   对比区间-结束时间
     * @return 交集的毫秒数
     */
    public static long overlapMils(Date currentStart, Date currentEnd, Date compareStart, Date compareEnd) {
        if (!existOverlaps(currentStart, currentEnd, compareStart, compareEnd)) {
            return 0L;
        }
        return Math.min(currentEnd.getTime(), compareEnd.getTime()) - Math.max(currentStart.getTime(), compareStart.getTime());
    }


    /**
     * 计算两个时间区间交集的毫秒数
     *
     * @param currentStart 当前区间-开始时间
     * @param currentEnd   当前区间-结束时间
     * @param compareStart 对比区间-开始时间
     * @param compareEnd   对比区间-结束时间
     * @return 交集的毫秒数
     */
    public static long overlapMils(LocalDateTime currentStart, LocalDateTime currentEnd, LocalDateTime compareStart, LocalDateTime compareEnd) {
        return overlapMils(toDate(currentStart), toDate(currentEnd), toDate(compareStart), toDate(compareEnd));
    }

    /**
     * 计算两个时间区间交集的毫秒数
     *
     * @param currentStart 当前区间-开始时间
     * @param currentEnd   当前区间-结束时间
     * @param compareStart 对比区间-开始时间
     * @param compareEnd   对比区间-结束时间
     * @return 交集的毫秒数
     */
    public static long overlapMils(LocalDate currentStart, LocalDate currentEnd, LocalDate compareStart, LocalDate compareEnd) {
        return overlapMils(toDate(currentStart), toDate(currentEnd), toDate(compareStart), toDate(compareEnd));
    }

    /**
     * 计算一个时间区间的年数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 年数（向上取整：超过部分不足1年按1年计算）
     */
    public static long yearsBetweenWithCeil(Date start, Date end) {
        ZonedDateTime startTime = TimeUtil.toZonedDateTime(start);
        ZonedDateTime endTime = TimeUtil.toZonedDateTime(end);
        long years = startTime.until(endTime, ChronoUnit.YEARS);
        if (startTime.plusYears(years).isBefore(endTime)
                && startTime.plusYears(years + 1L).isAfter(endTime)) {
            return years + 1;
        }
        return years;
    }

    /**
     * 计算一个时间区间的年数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 年数（向上取整：超过部分不足1年按1年计算）
     */
    public static long yearsBetweenWithCeil(LocalDateTime start, LocalDateTime end) {
        return yearsBetweenWithCeil(toDate(start), toDate(end));
    }

    /**
     * 计算一个时间区间的年数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 年数（向上取整：超过部分不足1年按1年计算）
     */
    public static long yearsBetweenWithCeil(LocalDate start, LocalDate end) {
        return yearsBetweenWithCeil(toDate(start), toDate(end));
    }

    /**
     * 计算一个时间区间的年数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 年数（向下取整：超过部分不足1年的舍弃掉）
     */
    public static long yearsBetweenWithFloor(Date start, Date end) {
        ZonedDateTime startTime = TimeUtil.toZonedDateTime(start);
        ZonedDateTime endTime = TimeUtil.toZonedDateTime(end);
        return startTime.until(endTime, ChronoUnit.YEARS);
    }

    /**
     * 计算一个时间区间的年数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 年数（向下取整：超过部分不足1年的舍弃掉）
     */
    public static long yearsBetweenWithFloor(LocalDateTime start, LocalDateTime end) {
        return yearsBetweenWithFloor(toDate(start), toDate(end));
    }

    /**
     * 计算一个时间区间的年数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 年数（向下取整：超过部分不足1年的舍弃掉）
     */
    public static long yearsBetweenWithFloor(LocalDate start, LocalDate end) {
        return yearsBetweenWithFloor(toDate(start), toDate(end));
    }

    /**
     * 计算一个时间区间的月数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 月数（向上取整：超过部分不足1个月按1个月计算）
     */
    public static long monthsBetweenWithCeil(Date start, Date end) {
        ZonedDateTime startTime = TimeUtil.toZonedDateTime(start);
        ZonedDateTime endTime = TimeUtil.toZonedDateTime(end);
        long months = startTime.until(endTime, ChronoUnit.MONTHS);
        if (startTime.plusMonths(months).isBefore(endTime)
                && startTime.plusMonths(months + 1L).isAfter(endTime)) {
            return months + 1;
        }
        return months;
    }

    /**
     * 计算一个时间区间的月数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 月数（向上取整：超过部分不足1个月按1个月计算）
     */
    public static long monthsBetweenWithCeil(LocalDateTime start, LocalDateTime end) {
        return monthsBetweenWithCeil(toDate(start), toDate(end));
    }

    /**
     * 计算一个时间区间的月数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 月数（向上取整：超过部分不足1个月按1个月计算）
     */
    public static long monthsBetweenWithCeil(LocalDate start, LocalDate end) {
        return monthsBetweenWithCeil(toDate(start), toDate(end));
    }

    /**
     * 计算一个时间区间的月数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 月数（向下取整：超过部分不足1个月的部分舍弃掉）
     */
    public static long monthsBetweenWithFloor(Date start, Date end) {
        ZonedDateTime startTime = TimeUtil.toZonedDateTime(start);
        ZonedDateTime endTime = TimeUtil.toZonedDateTime(end);
        return startTime.until(endTime, ChronoUnit.MONTHS);
    }

    /**
     * 计算一个时间区间的月数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 月数（向下取整：超过部分不足1个月的部分舍弃掉）
     */
    public static long monthsBetweenWithFloor(LocalDateTime start, LocalDateTime end) {
        return monthsBetweenWithFloor(toDate(start), toDate(end));
    }

    /**
     * 计算一个时间区间的月数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 月数（向下取整：超过部分不足1个月的部分舍弃掉）
     */
    public static long monthsBetweenWithFloor(LocalDate start, LocalDate end) {
        return monthsBetweenWithFloor(toDate(start), toDate(end));
    }

    /**
     * 计算一个时间区间的天数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 天数（向上取整：超过部分不足1天按1天计算）
     */
    public static long daysBetweenWithCeil(Date start, Date end) {
        return (end.getTime() - start.getTime()) % MILS_PER_DAY == 0L ? (end.getTime() - start.getTime()) / MILS_PER_DAY : (end.getTime() - start.getTime()) / MILS_PER_DAY + 1L;
    }

    /**
     * 计算一个时间区间的天数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 天数（向上取整：超过部分不足1天按1天计算）
     */
    public static long daysBetweenWithCeil(LocalDateTime start, LocalDateTime end) {
        return daysBetweenWithCeil(toDate(start), toDate(end));
    }

    /**
     * 计算一个时间区间的天数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 天数（向上取整：超过部分不足1天按1天计算）
     */
    public static long daysBetweenWithCeil(LocalDate start, LocalDate end) {
        return daysBetweenWithCeil(toDate(start), toDate(end));
    }

    /**
     * 计算一个时间区间的天数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 天数（向下取整：超过部分不足1天的部分舍弃掉）
     */
    public static long daysBetweenWithFloor(Date start, Date end) {
        return duration(start, end).toDays();
    }

    /**
     * 计算一个时间区间的天数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 天数（向下取整：超过部分不足1天的部分舍弃掉）
     */
    public static long daysBetweenWithFloor(LocalDateTime start, LocalDateTime end) {
        return duration(toDate(start), toDate(end)).toDays();
    }

    /**
     * 计算一个时间区间的天数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 天数（向下取整：超过部分不足1天的部分舍弃掉）
     */
    public static long daysBetweenWithFloor(LocalDate start, LocalDate end) {
        return duration(toDate(start), toDate(end)).toDays();
    }

    /**
     * 计算一个时间区间的天数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 天数（四舍五入：超过部分不足半天的舍弃掉，超过部分若大于或等于半天则按1天计算）
     */
    public static long daysBetweenWithRound(Date start, Date end) {
        long days = (end.getTime() - start.getTime()) / MILS_PER_DAY;
        long remindMils = (end.getTime() - start.getTime()) % MILS_PER_DAY;
        return days + (remindMils > MILS_PER_DAY / 2 ? 1 : 0);
    }

    /**
     * 计算一个时间区间的天数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 天数（四舍五入：超过部分不足半天的舍弃掉，超过部分若大于或等于半天则按1天计算）
     */
    public static long daysBetweenWithRound(LocalDateTime start, LocalDateTime end) {
        return daysBetweenWithRound(toDate(start), toDate(end));
    }

    /**
     * 计算一个时间区间的天数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 天数（四舍五入：超过部分不足半天的舍弃掉，超过部分若大于或等于半天则按1天计算）
     */
    public static long daysBetweenWithRound(LocalDate start, LocalDate end) {
        return daysBetweenWithRound(toDate(start), toDate(end));
    }

    /**
     * 计算一个时间区间的天数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 天数（向上取整：超过部分不足1天按1天计算）
     */
    public static long hoursBetweenWithCeil(Date start, Date end) {
        return (end.getTime() - start.getTime()) % MILS_PER_HOUR == 0L ? (end.getTime() - start.getTime()) / MILS_PER_HOUR : (end.getTime() - start.getTime()) / MILS_PER_HOUR + 1L;
    }

    /**
     * 计算一个时间区间的天数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 天数（向上取整：超过部分不足1天按1天计算）
     */
    public static long hoursBetweenWithCeil(LocalDateTime start, LocalDateTime end) {
        return hoursBetweenWithCeil(toDate(start), toDate(end));
    }

    /**
     * 计算一个时间区间的天数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 天数（向上取整：超过部分不足1天按1天计算）
     */
    public static long hoursBetweenWithCeil(LocalDate start, LocalDate end) {
        return hoursBetweenWithCeil(toDate(start), toDate(end));
    }

    /**
     * 计算一个时间区间的小时数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 小时数（向下取整：超过部分不足1小时的部分舍弃掉）
     */
    public static long hoursBetweenWithFloor(Date start, Date end) {
        return duration(start, end).toHours();
    }

    /**
     * 计算一个时间区间的小时数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 小时数（向下取整：超过部分不足1小时的部分舍弃掉）
     */
    public static long hoursBetweenWithFloor(LocalDateTime start, LocalDateTime end) {
        return duration(toDate(start), toDate(end)).toHours();
    }

    /**
     * 计算一个时间区间的小时数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 小时数（向下取整：超过部分不足1小时的部分舍弃掉）
     */
    public static long hoursBetweenWithFloor(LocalDate start, LocalDate end) {
        return duration(toDate(start), toDate(end)).toHours();
    }

    /**
     * 计算一个时间区间的小时数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 小时数（四舍五入：超过部分不足半小时的舍弃掉，超过部分若大于或等于半小时则按1小时计算）
     */
    public static long hoursBetweenWithRound(Date start, Date end) {
        long days = (end.getTime() - start.getTime()) / MILS_PER_HOUR;
        long remindMils = (end.getTime() - start.getTime()) % MILS_PER_HOUR;
        return days + (remindMils > MILS_PER_HOUR / 2 ? 1 : 0);
    }

    /**
     * 计算一个时间区间的小时数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 小时数（四舍五入：超过部分不足半小时的舍弃掉，超过部分若大于或等于半小时则按1小时计算）
     */
    public static long hoursBetweenWithRound(LocalDateTime start, LocalDateTime end) {
        return hoursBetweenWithRound(toDate(start), toDate(end));
    }

    /**
     * 计算一个时间区间的小时数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 小时数（四舍五入：超过部分不足半小时的舍弃掉，超过部分若大于或等于半小时则按1小时计算）
     */
    public static long hoursBetweenWithRound(LocalDate start, LocalDate end) {
        return hoursBetweenWithRound(toDate(start), toDate(end));
    }

    /**
     * 计算一个时间区间的分钟数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 分钟数（向上取整：超过部分不足1分钟按1分钟计算）
     */
    public static long minutesBetweenWithCeil(Date start, Date end) {
        return (end.getTime() - start.getTime()) % MILS_PER_MINUTE == 0L ? (end.getTime() - start.getTime()) / MILS_PER_MINUTE : (end.getTime() - start.getTime()) / MILS_PER_MINUTE + 1L;
    }

    /**
     * 计算一个时间区间的分钟数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 分钟数（向上取整：超过部分不足1分钟按1分钟计算）
     */
    public static long minutesBetweenWithCeil(LocalDateTime start, LocalDateTime end) {
        return minutesBetweenWithCeil(toDate(start), toDate(end));
    }

    /**
     * 计算一个时间区间的分钟数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 分钟数（向上取整：超过部分不足1分钟按1分钟计算）
     */
    public static long minutesBetweenWithCeil(LocalDate start, LocalDate end) {
        return minutesBetweenWithCeil(toDate(start), toDate(end));
    }

    /**
     * 计算一个时间区间的分钟数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 分钟数（向下取整：超过部分不足1分钟的部分舍弃掉）
     */
    public static long minutesBetweenWithFloor(Date start, Date end) {
        return duration(start, end).toMinutes();
    }

    /**
     * 计算一个时间区间的分钟数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 分钟数（向下取整：超过部分不足1分钟的部分舍弃掉）
     */
    public static long minutesBetweenWithFloor(LocalDate start, LocalDate end) {
        return duration(toDate(start), toDate(end)).toMinutes();
    }

    /**
     * 计算一个时间区间的分钟数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 分钟数（向下取整：超过部分不足1分钟的部分舍弃掉）
     */
    public static long minutesBetweenWithFloor(LocalDateTime start, LocalDateTime end) {
        return duration(toDate(start), toDate(end)).toMinutes();
    }

    /**
     * 计算一个时间区间的分钟数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 分钟数（四舍五入：超过部分不足半分钟的舍弃掉，超过部分若大于或等于半分钟则按1分钟计算）
     */
    public static long minutesBetweenWithRound(Date start, Date end) {
        long days = (end.getTime() - start.getTime()) / MILS_PER_MINUTE;
        long remindMils = (end.getTime() - start.getTime()) % MILS_PER_MINUTE;
        return days + (remindMils > MILS_PER_MINUTE / 2 ? 1 : 0);
    }

    /**
     * 计算一个时间区间的分钟数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 分钟数（四舍五入：超过部分不足半分钟的舍弃掉，超过部分若大于或等于半分钟则按1分钟计算）
     */
    public static long minutesBetweenWithRound(LocalDateTime start, LocalDateTime end) {
        return minutesBetweenWithRound(toDate(start), toDate(end));
    }

    /**
     * 计算一个时间区间的分钟数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 分钟数
     */
    public static long minutesBetween(LocalDate start, LocalDate end) {
        return minutesBetweenWithFloor(toDate(start), toDate(end));
    }

    /**
     * 计算一个时间区间的时长
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 时长
     */
    public static Duration duration(Date start, Date end) {
        LocalDateTime startLocalDateTime = TimeUtil.toLocalDateTime(start);
        LocalDateTime endLocalDateTime = TimeUtil.toLocalDateTime(end);
        return Duration.between(startLocalDateTime, endLocalDateTime);
    }

}
