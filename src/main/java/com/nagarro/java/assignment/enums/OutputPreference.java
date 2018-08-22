package com.nagarro.java.assignment.enums;

public enum OutputPreference {
    BYFARE,
    BYFAREANDDURATION;

    public static boolean isValidPreference(String preference)
    {

        for(OutputPreference op:OutputPreference.values()){

            if(op.toString().equals(preference))

            {

                return true;

            }

        }

        return false;

    }


}
