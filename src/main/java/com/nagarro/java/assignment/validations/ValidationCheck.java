package com.nagarro.java.assignment.validations;

public class ValidationCheck
{

    /**
     *
     * @param input
     * @return boolean
     * Checks valid Departure Location
     */
      public boolean isValidDapartureLoactaion(String input)
      {
          if (input.matches("[0-9]+") || input.length() != 3) {
              return false;
          }

        return true;
      }

    /**
     *
     * @param input
     * @return boolean
     * Checks valid Arrival Location
     */

    public boolean isValidArrivalLoactaion(String input)
    {
        if (input.matches("[0-9]+") || input.length() != 3) {
            return false;
        }

        return true;
    }

    /**
     *
     * @param input
     * @return boolean
     * Checks valid Flight Class
     */

    public boolean isValidClass(String input)
    {
        if (input.equalsIgnoreCase("E")||input.equalsIgnoreCase("B")) {
            return true;
        }

        return false;
    }




}
