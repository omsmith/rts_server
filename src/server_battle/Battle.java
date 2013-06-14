package server_battle;

public class Battle {
	public static void main(String args[]) {
		ToDoQueue toDoQueue = new ToDoQueue();
		MovementOrder_List movementOrder_List = new MovementOrder_List(toDoQueue);
		
		Integer numberofthreads = 4;
		Thread[] game = null;
		
		for(int x = 0; x<numberofthreads; x++){
			game[x] = new Thread(new TheQThread(toDoQueue));
			game[x].start();
		}
    }
}
