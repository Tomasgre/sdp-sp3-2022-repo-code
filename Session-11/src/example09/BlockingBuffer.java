package example09;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingBuffer implements Buffer {
	private ArrayBlockingQueue<Integer> buffer;

	public BlockingBuffer() {
		buffer = new ArrayBlockingQueue<Integer>(3);
	} // end BlockingBuffer constructor

	// place value into buffer
	public void set(int value) {
		try {
			buffer.put(value); // place value in circular buffer
			System.out.printf("%s%2d\t%s%d\n", "Producer writes ", value,
					"Buffers occupied: ", buffer.size());
		} // end try
		catch (Exception exception) {
			exception.printStackTrace();
		} // end catch
	} // end method set

	// return value from buffer
	public int get() {
		int readValue = 0; // initialize value read from buffer

		try {
			readValue = buffer.take(); // remove value from circular buffer
			System.out.printf("%s %2d\t%s%d\n", "Consumer reads ", readValue,
					"Buffers occupied: ", buffer.size());
		} // end try
		catch (Exception exception) {
			exception.printStackTrace();
		} // end catch

		return readValue;
	} // end method get
} // end class BlockingBuffer
