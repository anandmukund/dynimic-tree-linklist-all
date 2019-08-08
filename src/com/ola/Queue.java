package com.ola;


public  class Queue {

	public static Object Lock1 = new Object();
	int capacity = 2;
	Object queueArr[];
	int front = 0;
	int rear = -1;
	int currentSize = 0;

	public Queue(){
		queueArr = new Object[this.capacity];
	}
	public void push(Object item){
			synchronized (Lock1) {
				if (isQueueFull()) {
					System.out.println("Queue is full, increase capacity...");
					increaseCapacity();
				}
				rear++;
				if(rear >= queueArr.length && currentSize != queueArr.length){
					rear = 0;
				}
				queueArr[rear] = item;
				currentSize++;
				System.out.println("Adding: " + item);
			}
	}
	public boolean isQueueFull(){
		boolean status = false;
		if (currentSize == queueArr.length){
			status = true;
		}
		return status;
	}
	public boolean isQueueEmpty(){
		boolean status = false;
		if (currentSize == 0){
			status = true;
		}
		return status;
	}
	private void increaseCapacity(){

		int newCapacity = this.queueArr.length*2;
		Object[] newArr = new Object[newCapacity];
		int tmpFront = front;
		int index = -1;
		while(true){
			newArr[++index] = this.queueArr[tmpFront];
			tmpFront++;
			if(tmpFront == this.queueArr.length){
				tmpFront = 0;
			}
			if(currentSize == index+1){
				break;
			}
		}
		this.queueArr = newArr;
		System.out.println("New array capacity: "+this.queueArr.length);

		this.front = 0;
		this.rear = index;
	}

	public void pop() {
		synchronized (Lock1) {
			if (isQueueEmpty()) {
				System.out.println("Underflow ! Unable to remove element from Queue");
			} else {
				front++;
				if(front > queueArr.length-1){
					System.out.println("removed: "+queueArr[front-1]);
					front = 0;
				} else {
					System.out.println("removed: "+queueArr[front-1]);
				}
				currentSize--;
			}
		}
	}


	public void peek() {
		synchronized (Lock1) {
			if (isQueueEmpty()) {
				System.out.println("Underflow ! Unable to remove element from Queue");
			} else {
				System.out.println("top element is "+queueArr[currentSize-1]);

			}
		}
	}

	public static void main(String a[]){
		Queue queue = new Queue();
		queue.push(4);
		queue.peek();
		queue.pop();
		queue.push("34645");
		queue.push(2);
		queue.push(67);
		queue.push(122.22);
		queue.peek();
		queue.pop();
		queue.push(24);
		queue.push(98);
		queue.pop();
		queue.pop();
		queue.pop();
		queue.push(435);
		queue.pop();
		queue.pop();
	}
}