package com.liyingying;


import java.util.Calendar;
import java.util.Date;
import java.util.Locale;



import java.text.SimpleDateFormat;



public class DateUtils {
	/**
	 * 一天有多少毫秒
	 */
	
	static final long millisonSecondsPerDay =1000 * 60 * 60 * 24;
	
	/**
	 * 
	 * @Title: compare 
	 * @Description: TODO
	 * @param date1
	 * @param date2
	 * @return
	 * @return: int
	 */
	public static int compare(Date date1,Date date2) {
		
		if(date1 ==null || date2 == null)
			throw new RuntimeException("参数不能为空");
		
		return date1.compareTo(date2);
	}
	
	/**
	 * 
	 * @Title: calculateAge 
	 * @Description: 计算年龄
	 * @param birthday
	 * @return
	 * @return: int
	 */
	public static int calculateAge(Date birthday) {
		
		if(birthday.compareTo(new Date())>0) {
			
			throw new RuntimeException("给定的生日不能大于当前日期"+birthday);
		}
		

		//计算生日的年月日
		
			Calendar canlendar =Calendar.getInstance();
			canlendar.setTime(birthday);
			
			
			int  bdYear=canlendar.get(Calendar.YEAR);
			int  bdMonth=canlendar.get(Calendar.MONDAY);
			int  bdDay=canlendar.get(Calendar.DAY_OF_MONTH);
			
			System.out.println("bdYear:" + bdYear + " bdMonth: " + bdMonth + " bdDay:" + bdDay );
			
			//计算当前年月日
			canlendar.setTime(new Date());
			int currentYear=canlendar.get(Calendar.YEAR);
			int currentMonth=canlendar.get(Calendar.MONTH);
			int currentDay=canlendar.get(Calendar.DAY_OF_MONTH);
			
			System.out.println(
					" currentYear: " + currentYear + " currentMonth:" + currentMonth + " currentDay: " + currentDay);

			int age = currentYear - bdYear;
			if (currentMonth < bdMonth) {
				age--;
			} else if (currentMonth == bdMonth && currentDay < bdDay) {
				age--;
			}

			return age;
			
		}
	
		public static int remainDays(Date futureDate) throws CmsException {
		/**
		 * 给定的参数是否合法，小于当前日期则认为不合法，抛出异常
		 */
		if (futureDate.compareTo(new Date()) < 0) {
			throw new CmsException("未来日期不能小于当前日期 ： " + futureDate);
		}

		
		// 计算有多少天
		int days = (int) ((futureDate.getTime() - new Date().getTime()) / millisonSecondsPerDay);

		return days;

	}

		/**
		 * 判断是否为今天
		 * 
		 * @param date
		 * @return
		 */
		public static boolean isToday(Date date) {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			// 获取日期的字符串
			String dateStr = sdf.format(date);

			// 获取日期的字符串
			String todayStr = sdf.format(new Date());

			return (dateStr.equals(todayStr));

		}

		/**
		 * 判断是否在本周
		 * @param date
		 * @return
		 */
		public static boolean isThisWeek(Date date) {

			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

			Calendar firstDayOfWeek = Calendar.getInstance(Locale.getDefault());

			firstDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);

			int day = firstDayOfWeek.get(Calendar.DAY_OF_WEEK);

			firstDayOfWeek.add(Calendar.DATE, -day + 1 + 1);// 后面的+1是因为从周日开始

			// 本周一的日期

			System.out.println(format.format(firstDayOfWeek.getTime()));

			Calendar lastDayOfWeek = Calendar.getInstance(Locale.getDefault());

			lastDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);

			day = lastDayOfWeek.get(Calendar.DAY_OF_WEEK);

			lastDayOfWeek.add(Calendar.DATE, 7 - day + 1);

			// 本周星期天的日期

			System.out.println(format.format(lastDayOfWeek.getTime()));

			return (date.getTime() < lastDayOfWeek.getTime().getTime()
					&& date.getTime() > firstDayOfWeek.getTime().getTime());

		}
		
		/**
		 * 
		 * @param date
		 * @return
		 */
		public boolean isThisMonth(Date date) {
			// 自己去完成吧。。。
			return false;
		}
		
		
		
		/**
		 *  给定时间对象，初始化到该月初的1日0时0分0秒0毫秒
		 *  获取月初的时间  BOM（begin of the month） 
		 * @param date
		 * @return
		 * 
		 */
		public static Date getBOM(Date date) {
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			calendar.set(Calendar.HOUR, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);

			return calendar.getTime();
			
		}
		
		/**
		 *  先求出下一个月的月初  然后减一秒。就是本月月末的时间
		 *   
		 * @param date
		 * @return
		 */
		public static Date getEOM(Date date) {
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.MONTH, 1);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			calendar.set(Calendar.HOUR, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.add(Calendar.SECOND, -1);

			return calendar.getTime();
			
		}
		
		
		
		
	
	
}
