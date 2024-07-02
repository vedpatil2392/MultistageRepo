package com.dequeueinterface;


	import java.util.Deque;
	import java.util.LinkedList;

	public class StageQueue 
	{
	    Deque<Item> queue = new LinkedList<>();

	    public void addItem(Item item)
	    {
	        queue.addLast(item);
	    }

	    public Item getNextItem()
	    {
	        return queue.pollFirst();
	    }
	}



