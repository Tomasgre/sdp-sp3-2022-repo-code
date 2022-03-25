package example10;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RandomCharacters extends JFrame implements ActionListener {
	private static final long serialVersionUID = 0;
	private final static int SIZE = 3; // number of threads
	private JCheckBox checkboxes[]; // array of JCheckBoxes
	private Lock lockObject; // single lock
	// array of RunnableObjects to display random characters
	private RunnableObject[] randomCharacters;

	// set up GUI and arrays
	public RandomCharacters() {
		randomCharacters = new RunnableObject[SIZE];
		lockObject = new ReentrantLock(true);
		checkboxes = new JCheckBox[SIZE]; // allocate space for array
		setLayout(new GridLayout(SIZE, 2, 5, 5)); // set layout

		// create new thread pool with SIZE threads
		ExecutorService runner = Executors.newFixedThreadPool(SIZE);

		// loop SIZE times
		for (int count = 0; count < SIZE; count++) {
			JLabel outputJLabel = new JLabel(); // create JLabel
			outputJLabel.setBackground(Color.GREEN); // set color
			outputJLabel.setOpaque(true); // set JLabel to be opaque
			add(outputJLabel); // add JLabel to JFrame

			// create JCheckBox to control suspend/resume state
			checkboxes[count] = new JCheckBox("Suspended");

			// add listener which executes when JCheckBox is clicked
			checkboxes[count].addActionListener(this);
			add(checkboxes[count]); // add JCheckBox to JFrame

			// create a new RunnableObject
			randomCharacters[count] = new RunnableObject(lockObject, outputJLabel);

			// execute RunnableObject
			runner.execute(randomCharacters[count]);
		} // end for

		setSize(275, 90); // set size of window
		setVisible(true); // show window

		runner.shutdown(); // shutdown runner when threads finish
	} // end RandomCharacters constructor

	// handle JCheckBox events
	public void actionPerformed(ActionEvent event) {
		// loop over all JCheckBoxes in array
		for (int count = 0; count < checkboxes.length; count++) {
			// check if this JCheckBox was source of event
			if (event.getSource() == checkboxes[count])
				randomCharacters[count].toggle(); // toggle state
		} // end for
	} // end method actionPerformed

	public static void main(String args[]) {
		// create new RandomCharacters object
		RandomCharacters application = new RandomCharacters();

		// set application to end when window is closed
		application.setDefaultCloseOperation(EXIT_ON_CLOSE);
	} // end main
} // end class RandomCharacters
