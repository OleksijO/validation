package training.model;

import training.model.entity.notebook.Record;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * This class represents fake model for saving entities.
 * Instead of saving to DB for now it only prints them in console
 *
 * @version 1.0     06 NOV 2016
 * @author oleksij.onysymchuk@gmail.com
 */
public class Model {
    /**
     * The fake saved entity counter for fake method {@link #saveNotebookRecord(Record)}
     */
    private static AtomicInteger recordCounter = new AtomicInteger(1);

    /**
     * Fake method, which prints in console entity instead of saving to DB
     *
     * @param record the entity to be saved (printed)
     */
    public void saveNotebookRecord(Record record){
        int newId=recordCounter.getAndAdd(1);
        record.setId(newId);
        System.out.println("New notebook record:");
        System.out.println(record.toString());
        System.out.println("has been saved.");
    }

}
