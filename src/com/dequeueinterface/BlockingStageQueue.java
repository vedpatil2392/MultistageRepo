package com.dequeueinterface;


	import java.util.concurrent.BlockingDeque;
	import java.util.concurrent.LinkedBlockingDeque;
	import java.util.concurrent.TimeUnit;

	public class BlockingStageQueue
	{
	     BlockingDeque<Item> queue = new LinkedBlockingDeque<>();

	    public void addItem(Item item) throws InterruptedException
	    {
	        queue.putLast(item);
	    }

	    public Item getNextItem() throws InterruptedException
	    {
	        return queue.pollFirst(5, TimeUnit.SECONDS);
	    }
	}



