package com.telerikacademy.models.enums;

public enum Status {
    ACTIVE, FIXED, NOT_DONE, IN_PROGRESS, DONE, NEW, UNSCHEDULED, SCHEDULED;


    @Override
    public String toString() {
        switch (this){
            case ACTIVE:
                return "Active";
            case FIXED:
                return "Fixed";
            case NOT_DONE:
                return "Not done";
            case IN_PROGRESS:
                return "In progress";
            case DONE:
                return "Done";
            case NEW:
                return "New";
            case UNSCHEDULED:
                return "Unscheduled";
            case SCHEDULED:
                return "Scheduled";
            default:
                return "";
        }
    }
}
