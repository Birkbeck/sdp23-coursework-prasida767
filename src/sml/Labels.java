package sml;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

// TODO: write a JavaDoc for the class
/**
 * This class represents a collection of labels and their address during program execution.
 * Provides methods to add and retrieve labels, as well as a method to return a string representation of the labels map.
 * The class also implements equals and hashCode methods for use in the Machine class.
 * The class uses a HashMap to store the labels and their associated addresses, with the label name as the key and the address as the value.
 * Labels must be unique, and attempting to add a label that already exists will result in an IllegalArgumentException.
 * If an attempt is made to retrieve an address for a label that does not exist in the map, a NullPointerException will be thrown.
 * @author prasida767
 * **/

public final class Labels {
	private final Map<String, Integer> labels = new HashMap<>();

	/**
	 * Adds a label with the associated address to the map.
	 *
	 * @param label the label
	 * @param address the address the label refers to
	 */
	public void addLabel(String label, int address) {
		Objects.requireNonNull(label);
		// TODO: Add a check that there are no label duplicates. -> Completed
		if (labels.containsKey(label)) {
			throw new IllegalArgumentException("Label already exists: " + label);
		}
		labels.put(label, address);
	}

	/**
	 * Returns the address associated with the label.
	 *
	 * @param label the label
	 * @return the address the label refers to
	 */
	public int getAddress(String label) {
		// TODO: Where can NullPointerException be thrown here?
		//       (Write an explanation.)
		/* Answer */
		/* NullPointerException can be thrown when label that does not exist in the labels map is requested.
		 * When the line labels.get(label) tries to get non-existent label and return an Integer value, NullPointerException can be thrown.
		 * When a non-existent key in a map is tried to access, then the map returns a null value.
		 * When a null value is returned from labels Map then NullPointerException can be thrown.
		 * */
		//   TODO:   Add code to deal with non-existent labels. -> Completed
		if(labels.get(label) == null)
			throw new NullPointerException("No such label found:::" + label);

		return labels.get(label);
	}

	/**
	 * representation of this instance,
	 * in the form "[label -> address, label -> address, ..., label -> address]"
	 *
	 * @return the string representation of the labels map
	 */
	@Override
	public String toString() {
		// TODO: Implement the method using the Stream API (see also class Registers). -> Completed
		return labels.entrySet().stream()
				.map(entry -> entry.getKey() + " -> " + entry.getValue())
				.collect(Collectors.joining(", ", "[", "]"));
	}

	// TODO: Implement equals and hashCode (needed in class Machine). -> Completed

	/**
	 * Returns a hash code for this object.
	 *
	 * @return the hash code of this object
	 */
	@Override
	public int hashCode() {
		return Objects.hash(labels);
	}

	/**
	 * Checks whether this object is equal to the given object.
	 *
	 * @param obj the object to compare this object to
	 * @return true if the objects are equal, false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Labels other)
			return Objects.equals(labels, other.labels);
		return false;
	}

	/**
	 * Removes the labels
	 */
	public void reset() {
		labels.clear();
	}
}
