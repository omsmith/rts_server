package server_battle;

public class Battle {
	ToDoQueue toDoQueue = new ToDoQueue();
	MovementOrder_List movementOrder_List = new MovementOrder_List(toDoQueue);
}
