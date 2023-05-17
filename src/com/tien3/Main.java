package com.tien3;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Management management = new Management();

        boolean isQuit = false;
        Scanner scanner = new Scanner(System.in);

        while (!isQuit) {
            System.out.println("""
                    ========== Welcome to the Task Management Software ==========
                    1. Add new category
                    2. Delete category
                    3. Display all categories
                    4. Add new task
                    5. Delete task
                    6. Display all tasks
                    7. Read/Write data from file
                    8. Exit""");
            System.out.print("Please choose a menu(1 - 8): ");
            String select = scanner.nextLine().trim();
            switch (select) {
                case "1" -> {
                    System.out.println();
                    System.out.println("---------- Create new category ----------");
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    try {
                        management.addType(name);
                    } catch (Exception e) {
                        System.out.println("Addition failed: " + e.getMessage());
                    }
                    System.out.println();
                }
                case "2" -> {
                    System.out.println();
                    System.out.println("---------- Delete category ----------");
                    System.out.print("Enter the ID of the category to delete.: ");
                    String id = scanner.nextLine();
                    try {
                        management.deleteType(id);
                    } catch (Exception e) {
                        System.out.println("Deletion failed: " + e.getMessage());
                    }
                    System.out.println();
                }
                case "3" ->{
                    System.out.println();
                    System.out.println("---------- Display all categories ----------");
                    List<Type> types = management.getTypes();
                    System.out.printf("%-10s %-10s", "ID", "Name");
                    System.out.println();
                    for (Type type : types){
                        System.out.printf("%-10s %-10s", type.getId(), type.getName());
                        System.out.println();
                    }
                    System.out.println();
                }
                case "4" ->{
                    System.out.println();
                    System.out.println("---------- Add new task ----------");
                    System.out.print("Enter the task name: ");
                    String requirementName = scanner.nextLine();
                    System.out.print("Enter the category ID: ");
                    String taskTypeID = scanner.nextLine();
                    System.out.print("Enter the date (dd/MM/yyyy): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter the start time: ");
                    String planFrom = scanner.nextLine();
                    System.out.print("Enter the end time: ");
                    String planTo = scanner.nextLine();
                    System.out.print("Enter the name of the person responsible: ");
                    String assignee = scanner.nextLine();
                    System.out.print("Enter the name of the person to verify: ");
                    String reviewer = scanner.nextLine();
                    try {
                        management.addTask(requirementName, assignee, reviewer, taskTypeID, date, planFrom, planTo);
                    } catch (Exception e) {
                        System.out.println("Addition failed: " + e.getMessage());
                    }
                    System.out.println();
                }
                case "5" ->{
                    System.out.println();
                    System.out.println("---------- Delete task ----------");
                    System.out.print("Enter the ID of the task you want to delete: ");
                    String id = scanner.nextLine();
                    try {
                        management.deleteTask(id);
                    } catch (Exception e) {
                        System.out.println("Deletion failed: " + e.getMessage());
                    }
                    System.out.println();
                }
                case "6" -> {
                    System.out.println();
                    System.out.println("–".repeat(50) + " Display all tasks " + "–".repeat(50));
                    System.out.printf("%-10s %-30s %-20s %-20s %-20s %-20s %-20s", "ID", "Name", "Categories", "data", "Time", "Person responsible", "Person to verify");
                    System.out.println();
                    List<Task> tasks = management.getTasks();
                    for (Task task : tasks) {
                        System.out.printf("%-10s %-30s %-20s %-20s %-20s %-20s %-20s", task.getId(), task.getName(), task.getType(), task.getDate(), String.format("%.2f", task.getTime()), task.getAssignee(), task.getReviewer());
                        System.out.println();
                    }
                    System.out.println();
                }
                case "7" -> {
                    boolean isBack = false;
                    while (!isBack) {
                        System.out.println();
                        System.out.println("-".repeat(10) + " Read/Write data from/to file. " + "-".repeat(10));
                        System.out.println("""
                            (R)ead data
                            (W)rite data
                            (C)ome back""");
                        System.out.print("Enter your choice: ");
                        String selection = scanner.nextLine();
                        switch (selection.toUpperCase()) {
                            case "R" -> {
                                System.out.println("Reading data" + ".".repeat(20));
                                if (management.loadData()) {
                                    System.out.println("Successfully read data !");
                                }
                            }
                            case "W" -> {
                                System.out.println("Writing data" + ".".repeat(20));
                                if (management.saveData()) {
                                    System.out.println("successfully wrote data !");
                                }
                            }
                            case "C" -> {
                                isBack = true;
                            }
                        }
                    }

                }
                case "8" -> {
                    isQuit = true;
                }
            }
        }
    }
}
