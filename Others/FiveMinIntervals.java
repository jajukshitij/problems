public class FiveMinIntervals {
  /*
  https://leetcode.com/discuss/interview-question/1583430/doordash-questions-consolidated
  https://leetcode.com/discuss/interview-question/1553504/DoorDash-or-Phone-Interview-or-SFO-or-Senior-software-engineer

  You are given 2 strings.  startTime : "mon 10:45 am" and  endTime: "mon 11:00 am". 
  You need to output all the times between starttime and endtime in the interval of 5 minutes. 
  output: ["11045", "11050","11055", "11100"]. 
  in output each string represents the day+hour+minute. eg: 11045: 1+10+45 => monday represents 1. tuesday 2 etc. 
  Also, the output should be in 24hr format and input will be in 12hr format. you are required to do input validations as they can have invalid time formats.
  */
  
    private static final Map<String, Integer> dayMap = Map.of(
        "mon", 1, "tue", 2, "wed", 3, "thu", 4, "fri", 5, "sat", 6, "sun", 7
    );

    public static List<String> generateTimeIntervals(String startTime, String endTime) {
        List<String> result = new ArrayList<>();
        
        try {
            // Parse input times
            String[] startParts = parseTime(startTime);
            String[] endParts = parseTime(endTime);

            // Convert to calendar objects
            Calendar startCal = to24HourCalendar(startParts);
            Calendar endCal = to24HourCalendar(endParts);

            // Validation: Start time should be earlier than end time
            if (!startCal.before(endCal)) {
                throw new IllegalArgumentException("Start time must be before end time.");
            }

            // Generate intervals
            while (startCal.before(endCal)) {
                result.add(formatTime(startCal));
                startCal.add(Calendar.MINUTE, 5); // Increment by 5 minutes
            }
            result.add(formatTime(endCal)); // Add the end time itself if required

        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid input: " + e.getMessage());
        }
        
        return result;
    }

    private static String[] parseTime(String time) {
        String[] parts = time.split(" ");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid time format. Expected format: 'day hh:mm am/pm'");
        }

        String day = parts[0].toLowerCase();
        if (!dayMap.containsKey(day)) {
            throw new IllegalArgumentException("Invalid day of the week: " + day);
        }

        String[] hourMinute = parts[1].split(":");
        if (hourMinute.length != 2 || !parts[2].matches("(am|pm)")) {
            throw new IllegalArgumentException("Invalid time format. Expected hh:mm am/pm");
        }

        return new String[] { day, hourMinute[0], hourMinute[1], parts[2] };
    }

    private static Calendar to24HourCalendar(String[] timeParts) {
        int day = dayMap.get(timeParts[0]);
        int hour = Integer.parseInt(timeParts[1]);
        int minute = Integer.parseInt(timeParts[2]);
        boolean isPM = timeParts[3].equals("pm");

        // Validate hour and minute
        if (hour < 1 || hour > 12 || minute < 0 || minute >= 60) {
            throw new IllegalArgumentException("Invalid hour or minute: " + hour + ":" + minute);
        }

        // Convert to 24-hour format
        if (hour == 12) hour = 0; // Handle 12am/pm
        if (isPM) hour += 12;

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, day);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal;
    }

    private static String formatTime(Calendar cal) {
        int day = cal.get(Calendar.DAY_OF_WEEK);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);

        return String.format("%d%02d%02d", day, hour, minute);
    }

    public static void main(String[] args) {
        // Test case
        String startTime = "mon 10:45 am";
        String endTime = "mon 11:00 am";

        List<String> result = generateTimeIntervals(startTime, endTime);
        System.out.println(result); // Expected output: [11045, 11050, 11055, 11100]
    }
}
