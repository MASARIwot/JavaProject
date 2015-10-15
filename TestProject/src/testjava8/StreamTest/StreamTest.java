package testjava8;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest {

	private enum Status {
		OPEN, CLOSED
	};

	final static Collection<Task> tasks = Arrays.asList(
			new Task(Status.OPEN, 5), 
			new Task(Status.OPEN, 14), 
			new Task(Status.CLOSED, 10), 
			new Task(Status.OPEN, 1), 
			new Task(Status.OPEN, 10), 
			new Task(Status.CLOSED, 8));
	
	final static long totalPointsOfOpenTasks = tasks.stream()
													.filter(task -> task.getStatus() == Status.OPEN)
													.mapToInt(Task::getPoints).sum();
	
	
//	final static double totalPoints = tasks
//			   .stream()
//			   .parallel()
//			   .map( task -> task.getPoints() ) // or map( Task::getPoints )
//			   .reduce( 0, Integer::sum );


	private static final class Task {
		private final Status status;
		private final Integer points;
//
		Task(final Status status, final Integer points) {
			this.status = status;
			this.points = points;
		}

		public Integer getPoints() {
			return points;
		}

		public Status getStatus() {
			return status;
		}

		@Override
		public String toString() {
			return String.format("[%s, %d]", status, points);
		}
	}

	public static class TestClass {

		public static void main(String[] args) throws IOException {
			System.out.println("Total points: " + totalPointsOfOpenTasks);

			System.out.println(new Task(Status.OPEN, 10).toString());
			double totalPoints = tasks //it was a problem with static init ..did not working !!!
					   .stream()
					   .parallel()
					   .map( task -> task.getPoints() ) // or map( Task::getPoints )
					   .reduce( 0, Integer::sum );
			System.out.println(totalPoints);
			
			Map<Status, List<Task>> map = tasks
					.stream()
					.collect(Collectors.groupingBy(Task :: getStatus));
			System.out.println( map );

		}
	}
}
