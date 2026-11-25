package com.dufuna.berlin.jesutofunmiogundare.collections;

import com.dufuna.berlin.jesutofunmiogundare.model.LekkiProperty;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

/**
 * Sprint 4: practice with the Java Collections Framework.
 *
 * A "collection" is an object that holds a group of other objects.
 * Java gives us ready-made ones in java.util, mainly:
 *   - List  : ordered, allows duplicates, access by position (index)
 *   - Set   : no duplicates allowed
 *   - Map   : stores key -> value pairs, look up a value by its key
 *   - Queue : holds items waiting to be processed, usually first-in-first-out
 *
 * Each demo method below shows one of these, then the last two
 * use them with my own LekkiProperty class.
 */
public class CollectionsDemo {

    public static void main(String[] args) {
        arrayListDemo();
        hashSetDemo();
        treeSetDemo();
        hashMapDemo();
        queueDemo();

        // The part that connects to my own project
        List<LekkiProperty> properties = lekkiPropertyListDemo();
        lekkiPropertyMapDemo(properties);
    }

    /**
     * ArrayList is a List backed by a resizable array.
     * - Keeps items in the order you added them.
     * - Allows duplicates.
     * - Fast to read by index, e.g. list.get(0).
     */
    private static void arrayListDemo() {
        System.out.println("=== ArrayList (List) ===");

        // Declare the variable as the interface (List) and create the class (ArrayList).
        // That way I could switch to another List later without changing other code.
        List<String> areas = new ArrayList<>();
        areas.add("Lekki Phase 1");
        areas.add("Ikate");
        areas.add("Chevron");
        areas.add("Ikate"); // duplicate on purpose, a List keeps it

        System.out.println("List contents: " + areas);
        System.out.println("Size (duplicate counted): " + areas.size());
        System.out.println("First item by index 0: " + areas.get(0));

        // Loop through the list. Items come out in the same order they went in.
        for (String area : areas) {
            System.out.println(" - " + area);
        }
        System.out.println();
    }

    /**
     * HashSet is a Set that uses hashing to store items.
     * - Does NOT allow duplicates (adding the same item again is ignored).
     * - Does NOT promise any particular order.
     * - Very fast for "is this item in the set?" checks.
     */
    private static void hashSetDemo() {
        System.out.println("=== HashSet (Set) ===");

        Set<String> propertyTypes = new HashSet<>();
        propertyTypes.add("Duplex");
        propertyTypes.add("Flat");
        propertyTypes.add("Bungalow");
        propertyTypes.add("Terrace");

        // add() returns false when the item is already there, so the duplicate is dropped
        boolean added = propertyTypes.add("Flat");
        System.out.println("Tried to add \"Flat\" again, was it added? " + added);

        System.out.println("Set contents (order not guaranteed): " + propertyTypes);
        System.out.println("Size (no duplicates): " + propertyTypes.size());
        System.out.println("Contains \"Duplex\"? " + propertyTypes.contains("Duplex"));
        System.out.println();
    }

    /**
     * TreeSet is a Set that keeps its items sorted.
     * - Still no duplicates (it is a Set).
     * - Items are always in sorted order (alphabetical for Strings, smallest first for numbers).
     * - A bit slower than HashSet because it has to keep things sorted.
     */
    private static void treeSetDemo() {
        System.out.println("=== TreeSet (sorted Set) ===");

        Set<Integer> bedroomCounts = new TreeSet<>();
        bedroomCounts.add(5);
        bedroomCounts.add(2);
        bedroomCounts.add(4);
        bedroomCounts.add(1);
        bedroomCounts.add(2); // duplicate, ignored

        // Added as 5, 2, 4, 1, 2 but printed sorted and without the duplicate
        System.out.println("Added 5, 2, 4, 1, 2 -> TreeSet: " + bedroomCounts);
        System.out.println();
    }

    /**
     * HashMap is a Map: it stores key -> value pairs.
     * - Each key is unique; putting the same key again replaces the old value.
     * - You get a value back quickly by giving its key: map.get(key).
     * - Like HashSet, order is not guaranteed.
     */
    private static void hashMapDemo() {
        System.out.println("=== HashMap (Map) ===");

        // Key = area name, value = average rent in Naira
        Map<String, Integer> averageRent = new HashMap<>();
        averageRent.put("Lekki Phase 1", 5_000_000);
        averageRent.put("Ikate", 3_500_000);
        averageRent.put("Chevron", 4_000_000);

        System.out.println("Map contents: " + averageRent);

        // Look up one value by its key
        System.out.println("Average rent in Ikate: " + averageRent.get("Ikate"));

        // Looking up a key that is not there gives null
        System.out.println("Average rent in Ajah (not added): " + averageRent.get("Ajah"));

        // Loop through every key -> value pair
        for (Map.Entry<String, Integer> entry : averageRent.entrySet()) {
            System.out.println(" - " + entry.getKey() + " => " + entry.getValue());
        }
        System.out.println();
    }

    /**
     * Queue holds items waiting their turn: First-In-First-Out (FIFO),
     * like people in a line at the bank.
     * LinkedList implements the Queue interface, so we can use it as one.
     * - offer() adds to the back of the line.
     * - poll()  removes and returns the item at the front (or null if empty).
     * - peek()  looks at the front item without removing it.
     */
    private static void queueDemo() {
        System.out.println("=== Queue (LinkedList used as a Queue) ===");

        Queue<String> viewingRequests = new LinkedList<>();
        viewingRequests.offer("Ada");
        viewingRequests.offer("Bola");
        viewingRequests.offer("Chidi");

        System.out.println("Queue: " + viewingRequests);
        System.out.println("Next in line (peek): " + viewingRequests.peek());

        // Remove until empty. Names come out in the same order they joined.
        while (!viewingRequests.isEmpty()) {
            System.out.println("Serving: " + viewingRequests.poll());
        }
        System.out.println("Queue after serving everyone: " + viewingRequests);
        System.out.println();
    }

    /**
     * Use an ArrayList to hold several LekkiProperty objects
     * and loop through them.
     */
    private static List<LekkiProperty> lekkiPropertyListDemo() {
        System.out.println("=== LekkiProperty objects in an ArrayList ===");

        List<LekkiProperty> properties = new ArrayList<>();
        properties.add(createProperty("LP-001", "12 Admiralty Way, Lekki Phase 1", "Duplex", 4, "Mr. Adeyemi"));
        properties.add(createProperty("LP-002", "5 Ikate Road, Ikate", "Flat", 2, "Mrs. Okafor"));
        properties.add(createProperty("LP-003", "30 Chevron Drive, Chevron", "Bungalow", 3, "Mr. Bello"));
        properties.add(createProperty("LP-004", "8 Freedom Way, Lekki Phase 1", "Terrace", 5, "Ms. Eze"));

        System.out.println("Number of properties: " + properties.size());
        for (LekkiProperty property : properties) {
            System.out.println(" - " + property.getPropertyId() + ": "
                    + property.getType() + ", "
                    + property.getNumberOfBedrooms() + " bedrooms, "
                    + property.getAddress());
        }
        System.out.println();
        return properties;
    }

    /**
     * Put the same LekkiProperty objects into a HashMap keyed by propertyId.
     *
     * Why a Map is handy here: to find a property by its id in a List,
     * I would have to loop through every item and compare ids one by one.
     * With a Map I just call map.get(id) and get it straight away,
     * however many properties there are.
     */
    private static void lekkiPropertyMapDemo(List<LekkiProperty> properties) {
        System.out.println("=== LekkiProperty objects in a HashMap (key = propertyId) ===");

        Map<String, LekkiProperty> propertiesById = new HashMap<>();
        for (LekkiProperty property : properties) {
            propertiesById.put(property.getPropertyId(), property);
        }

        System.out.println("Map has " + propertiesById.size() + " properties, keys: " + propertiesById.keySet());

        // Direct lookup by id, no loop needed
        String idToFind = "LP-003";
        LekkiProperty found = propertiesById.get(idToFind);
        System.out.println("Lookup " + idToFind + " -> " + found.getType()
                + " at " + found.getAddress() + ", owner " + found.getOwner());

        // An id that does not exist returns null, so check before using it
        String missingId = "LP-999";
        LekkiProperty missing = propertiesById.get(missingId);
        System.out.println("Lookup " + missingId + " -> "
                + (missing == null ? "not found" : missing.getAddress()));
        System.out.println();
    }

    /**
     * Small helper to build a LekkiProperty, since the class only has
     * a no-argument constructor plus setters.
     */
    private static LekkiProperty createProperty(String id, String address, String type,
                                                int bedrooms, String owner) {
        LekkiProperty property = new LekkiProperty();
        property.setPropertyId(id);
        property.setAddress(address);
        property.setType(type);
        property.setNumberOfBedrooms(bedrooms);
        property.setNumberOfSittingRooms(1);
        property.setNumberOfKitchens(1);
        property.setNumberOfBathrooms(bedrooms);
        property.setNumberOfToilets(bedrooms + 1);
        property.setOwner(owner);
        property.setDescription(bedrooms + "-bedroom " + type.toLowerCase() + " in Lekki");
        property.setValidFrom(LocalDate.of(2026, 1, 1));
        property.setValidTo(LocalDate.of(2026, 12, 31));
        return property;
    }
}
