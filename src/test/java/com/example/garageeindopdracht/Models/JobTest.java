package com.example.garageeindopdracht.Models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

class JobTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Job#Job()}
     *   <li>{@link Job#setCarLicensePlate(String)}
     *   <li>{@link Job#setCustomerName(String)}
     *   <li>{@link Job#setCustomerPhoneNumber(String)}
     *   <li>{@link Job#setJobDescription(String)}
     *   <li>{@link Job#setJobID(long)}
     *   <li>{@link Job#setPartsUsedForRepair(String)}
     *   <li>{@link Job#setPartsUsedForRepairPrices(String)}
     *   <li>{@link Job#setStatus(int)}
     *   <li>{@link Job#getCarLicensePlate()}
     *   <li>{@link Job#getCustomerName()}
     *   <li>{@link Job#getCustomerPhoneNumber()}
     *   <li>{@link Job#getJobDescription()}
     *   <li>{@link Job#getJobID()}
     *   <li>{@link Job#getPartsUsedForRepair()}
     *   <li>{@link Job#getPartsUsedForRepairPrices()}
     *   <li>{@link Job#getStatus()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Job actualJob = new Job();
        actualJob.setCarLicensePlate("Car License Plate");
        actualJob.setCustomerName("Customer Name");
        actualJob.setCustomerPhoneNumber("4105551212");
        actualJob.setJobDescription("Job Description");
        actualJob.setJobID(1L);
        actualJob.setPartsUsedForRepair("Parts Used For Repair");
        actualJob.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        actualJob.setStatus(1);
        assertEquals("Car License Plate", actualJob.getCarLicensePlate());
        assertEquals("Customer Name", actualJob.getCustomerName());
        assertEquals("4105551212", actualJob.getCustomerPhoneNumber());
        assertEquals("Job Description", actualJob.getJobDescription());
        assertEquals(1L, actualJob.getJobID());
        assertEquals("Parts Used For Repair", actualJob.getPartsUsedForRepair());
        assertEquals("Parts Used For Repair Prices", actualJob.getPartsUsedForRepairPrices());
        assertEquals(1, actualJob.getStatus());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Job#Job(String, String, String, String, int)}
     *   <li>{@link Job#setCarLicensePlate(String)}
     *   <li>{@link Job#setCustomerName(String)}
     *   <li>{@link Job#setCustomerPhoneNumber(String)}
     *   <li>{@link Job#setJobDescription(String)}
     *   <li>{@link Job#setJobID(long)}
     *   <li>{@link Job#setPartsUsedForRepair(String)}
     *   <li>{@link Job#setPartsUsedForRepairPrices(String)}
     *   <li>{@link Job#setStatus(int)}
     *   <li>{@link Job#getCarLicensePlate()}
     *   <li>{@link Job#getCustomerName()}
     *   <li>{@link Job#getCustomerPhoneNumber()}
     *   <li>{@link Job#getJobDescription()}
     *   <li>{@link Job#getJobID()}
     *   <li>{@link Job#getPartsUsedForRepair()}
     *   <li>{@link Job#getPartsUsedForRepairPrices()}
     *   <li>{@link Job#getStatus()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        Job actualJob = new Job("Car License Plate", "Customer Name", "4105551212", "Job Description", 1);
        actualJob.setCarLicensePlate("Car License Plate");
        actualJob.setCustomerName("Customer Name");
        actualJob.setCustomerPhoneNumber("4105551212");
        actualJob.setJobDescription("Job Description");
        actualJob.setJobID(1L);
        actualJob.setPartsUsedForRepair("Parts Used For Repair");
        actualJob.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        actualJob.setStatus(1);
        assertEquals("Car License Plate", actualJob.getCarLicensePlate());
        assertEquals("Customer Name", actualJob.getCustomerName());
        assertEquals("4105551212", actualJob.getCustomerPhoneNumber());
        assertEquals("Job Description", actualJob.getJobDescription());
        assertEquals(1L, actualJob.getJobID());
        assertEquals("Parts Used For Repair", actualJob.getPartsUsedForRepair());
        assertEquals("Parts Used For Repair Prices", actualJob.getPartsUsedForRepairPrices());
        assertEquals(1, actualJob.getStatus());
    }

    /**
     * Method under test: {@link Job#addPartToString(String)}
     */
    @Test
    void testAddPartToString() {
        Job job = new Job();
        job.addPartToString("New Part");
        assertEquals("New Part;", job.getPartsUsedForRepair());
    }

    /**
     * Method under test: {@link Job#addPartToString(String)}
     */
    @Test
    void testAddPartToString2() {
        Job job = new Job();
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        job.addPartToString("foo");
        assertEquals("Parts Used For Repairfoo;", job.getPartsUsedForRepair());
    }

    /**
     * Method under test: {@link Job#addPartPriceToString(String)}
     */
    @Test
    void testAddPartPriceToString() {
        Job job = new Job();
        job.addPartPriceToString("New Part Price");
        assertEquals("New Part Price;", job.getPartsUsedForRepairPrices());
    }

    /**
     * Method under test: {@link Job#addPartPriceToString(String)}
     */
    @Test
    void testAddPartPriceToString2() {
        Job job = new Job();
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        job.addPartPriceToString("foo");
        assertEquals("Parts Used For Repair Pricesfoo;", job.getPartsUsedForRepairPrices());
    }

    /**
     * Method under test: {@link Job#getPartsList()}
     */
    @Test
    void testGetPartsList() {
        assertTrue((new Job()).getPartsList().isPresent());
    }

    /**
     * Method under test: {@link Job#getPartsList()}
     */
    @Test
    void testGetPartsList2() {
        Job job = new Job();
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        Optional<List<String>> actualPartsList = job.getPartsList();
        assertTrue(actualPartsList.isPresent());
        List<String> getResult = actualPartsList.get();
        assertEquals(1, getResult.size());
        assertEquals("Parts Used For Repair", getResult.get(0));
    }

    /**
     * Method under test: {@link Job#getPartsPricesList()}
     */
    @Test
    void testGetPartsPricesList() {
        assertTrue((new Job()).getPartsPricesList().isPresent());
    }

    /**
     * Method under test: {@link Job#getPartsPricesList()}
     */
    @Test
    void testGetPartsPricesList2() {
        Job job = new Job();
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        Optional<List<String>> actualPartsPricesList = job.getPartsPricesList();
        assertTrue(actualPartsPricesList.isPresent());
        List<String> getResult = actualPartsPricesList.get();
        assertEquals(1, getResult.size());
        assertEquals("Parts Used For Repair Prices", getResult.get(0));
    }

    /**
     * Method under test: {@link Job#getPartPricesListDouble()}
     */
    @Test
    void testGetPartPricesListDouble() {
        assertTrue((new Job()).getPartPricesListDouble().isPresent());
    }

    /**
     * Method under test: {@link Job#getPartPricesListDouble()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetPartPricesListDouble2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "Parts Used For Repair Prices"
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //   In order to prevent getPartPricesListDouble()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getPartPricesListDouble().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        job.getPartPricesListDouble();
    }

    /**
     * Method under test: {@link Job#getPartPricesListDouble()}
     */
    @Test
    void testGetPartPricesListDouble3() {
        Job job = new Job();
        job.addPartPriceToString("42");
        Optional<List<Double>> actualPartPricesListDouble = job.getPartPricesListDouble();
        assertTrue(actualPartPricesListDouble.isPresent());
        List<Double> getResult = actualPartPricesListDouble.get();
        assertEquals(1, getResult.size());
        assertEquals(42.0d, getResult.get(0));
    }

    /**
     * Method under test: {@link Job#getPartPricesListDouble()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetPartPricesListDouble4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "."
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //   In order to prevent getPartPricesListDouble()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getPartPricesListDouble().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.addPartPriceToString(",");
        job.addPartPriceToString("42");
        job.getPartPricesListDouble();
    }

    /**
     * Method under test: {@link Job#getPartPricesListDouble()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetPartPricesListDouble5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: multiple points
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:1890)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //   In order to prevent getPartPricesListDouble()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getPartPricesListDouble().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setPartsUsedForRepairPrices(",");
        job.addPartPriceToString(",");
        job.addPartPriceToString("42");
        job.getPartPricesListDouble();
    }

    /**
     * Method under test: {@link Job#getPartPricesListDouble()}
     */
    @Test
    void testGetPartPricesListDouble6() {
        Job job = new Job();
        job.setPartsUsedForRepairPrices(",");
        job.addPartPriceToString("42");
        Optional<List<Double>> actualPartPricesListDouble = job.getPartPricesListDouble();
        assertTrue(actualPartPricesListDouble.isPresent());
        List<Double> getResult = actualPartPricesListDouble.get();
        assertEquals(1, getResult.size());
        assertEquals(0.42d, getResult.get(0));
    }

    /**
     * Method under test: {@link Job#getPartPricesListDouble()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetPartPricesListDouble7() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: multiple points
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:1890)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //   In order to prevent getPartPricesListDouble()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getPartPricesListDouble().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setPartsUsedForRepairPrices(".");
        job.addPartPriceToString(",");
        job.addPartPriceToString("42");
        job.getPartPricesListDouble();
    }

    /**
     * Method under test: {@link Job#getPartPricesListDouble()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetPartPricesListDouble8() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "Parts Used For Repair Prices."
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //   In order to prevent getPartPricesListDouble()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getPartPricesListDouble().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.addPartPriceToString(",");
        job.addPartPriceToString("42");
        job.getPartPricesListDouble();
    }

    /**
     * Method under test: {@link Job#getPartPricesListDouble()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetPartPricesListDouble9() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "java.lang.String."
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //   In order to prevent getPartPricesListDouble()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getPartPricesListDouble().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setPartsUsedForRepairPrices("java.lang.String");
        job.addPartPriceToString(",");
        job.addPartPriceToString("42");
        job.getPartPricesListDouble();
    }

    /**
     * Method under test: {@link Job#getPartPricesListDouble()}
     */
    @Test
    void testGetPartPricesListDouble10() {
        Job job = new Job();
        job.setPartsUsedForRepairPrices("42");
        job.addPartPriceToString(",");
        job.addPartPriceToString("42");
        Optional<List<Double>> actualPartPricesListDouble = job.getPartPricesListDouble();
        assertTrue(actualPartPricesListDouble.isPresent());
        List<Double> getResult = actualPartPricesListDouble.get();
        assertEquals(2, getResult.size());
        assertEquals(42.0d, getResult.get(0));
        assertEquals(42.0d, getResult.get(1));
    }

    /**
     * Method under test: {@link Job#getPartPricesListDouble()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetPartPricesListDouble11() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "java.util.List."
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //   In order to prevent getPartPricesListDouble()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getPartPricesListDouble().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setPartsUsedForRepairPrices("java.util.List");
        job.addPartPriceToString(",");
        job.addPartPriceToString("42");
        job.getPartPricesListDouble();
    }

    /**
     * Method under test: {@link Job#getPartPricesListDouble()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetPartPricesListDouble12() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: multiple points
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:1890)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //   In order to prevent getPartPricesListDouble()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getPartPricesListDouble().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setPartsUsedForRepairPrices(",");
        job.addPartPriceToString(".");
        job.addPartPriceToString("42");
        job.getPartPricesListDouble();
    }

    /**
     * Method under test: {@link Job#getPartPricesListDouble()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetPartPricesListDouble13() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: ".New Part Price"
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //   In order to prevent getPartPricesListDouble()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getPartPricesListDouble().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setPartsUsedForRepairPrices(",");
        job.addPartPriceToString("New Part Price");
        job.addPartPriceToString("42");
        job.getPartPricesListDouble();
    }

    /**
     * Method under test: {@link Job#getPartPricesListDouble()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetPartPricesListDouble14() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: ".null"
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //   In order to prevent getPartPricesListDouble()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getPartPricesListDouble().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setPartsUsedForRepairPrices(",");
        job.addPartPriceToString(null);
        job.addPartPriceToString("42");
        job.getPartPricesListDouble();
    }

    /**
     * Method under test: {@link Job#getPartPricesListDouble()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetPartPricesListDouble15() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: ".java.lang.String"
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //   In order to prevent getPartPricesListDouble()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getPartPricesListDouble().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setPartsUsedForRepairPrices(",");
        job.addPartPriceToString("java.lang.String");
        job.addPartPriceToString("42");
        job.getPartPricesListDouble();
    }

    /**
     * Method under test: {@link Job#getPartPricesListDouble()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetPartPricesListDouble16() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: ".java.util.List"
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //   In order to prevent getPartPricesListDouble()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getPartPricesListDouble().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setPartsUsedForRepairPrices(",");
        job.addPartPriceToString("java.util.List");
        job.addPartPriceToString("42");
        job.getPartPricesListDouble();
    }

    /**
     * Method under test: {@link Job#getTotalRepairCost()}
     */
    @Test
    void testGetTotalRepairCost() {
        assertEquals(0.0d, (new Job()).getTotalRepairCost());
    }

    /**
     * Method under test: {@link Job#getTotalRepairCost()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetTotalRepairCost2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "Parts Used For Repair Prices"
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //       at com.example.garageeindopdracht.Models.Job.getTotalRepairCost(Job.java:102)
        //   In order to prevent getTotalRepairCost()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getTotalRepairCost().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        job.getTotalRepairCost();
    }

    /**
     * Method under test: {@link Job#getTotalRepairCost()}
     */
    @Test
    void testGetTotalRepairCost3() {
        Job job = new Job();
        job.addPartPriceToString("42");
        assertEquals(42.0d, job.getTotalRepairCost());
    }

    /**
     * Method under test: {@link Job#getTotalRepairCost()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetTotalRepairCost4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "."
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //       at com.example.garageeindopdracht.Models.Job.getTotalRepairCost(Job.java:102)
        //   In order to prevent getTotalRepairCost()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getTotalRepairCost().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.addPartPriceToString(",");
        job.addPartPriceToString("42");
        job.getTotalRepairCost();
    }

    /**
     * Method under test: {@link Job#getTotalRepairCost()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetTotalRepairCost5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: multiple points
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:1890)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //       at com.example.garageeindopdracht.Models.Job.getTotalRepairCost(Job.java:102)
        //   In order to prevent getTotalRepairCost()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getTotalRepairCost().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setPartsUsedForRepairPrices(",");
        job.addPartPriceToString(",");
        job.addPartPriceToString("42");
        job.getTotalRepairCost();
    }

    /**
     * Method under test: {@link Job#getTotalRepairCost()}
     */
    @Test
    void testGetTotalRepairCost6() {
        Job job = new Job();
        job.setPartsUsedForRepairPrices(",");
        job.addPartPriceToString("42");
        assertEquals(0.42d, job.getTotalRepairCost());
    }

    /**
     * Method under test: {@link Job#getTotalRepairCost()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetTotalRepairCost7() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: multiple points
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:1890)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //       at com.example.garageeindopdracht.Models.Job.getTotalRepairCost(Job.java:102)
        //   In order to prevent getTotalRepairCost()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getTotalRepairCost().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setPartsUsedForRepairPrices(".");
        job.addPartPriceToString(",");
        job.addPartPriceToString("42");
        job.getTotalRepairCost();
    }

    /**
     * Method under test: {@link Job#getTotalRepairCost()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetTotalRepairCost8() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "Parts Used For Repair Prices."
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //       at com.example.garageeindopdracht.Models.Job.getTotalRepairCost(Job.java:102)
        //   In order to prevent getTotalRepairCost()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getTotalRepairCost().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.addPartPriceToString(",");
        job.addPartPriceToString("42");
        job.getTotalRepairCost();
    }

    /**
     * Method under test: {@link Job#getTotalRepairCost()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetTotalRepairCost9() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "java.lang.String."
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //       at com.example.garageeindopdracht.Models.Job.getTotalRepairCost(Job.java:102)
        //   In order to prevent getTotalRepairCost()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getTotalRepairCost().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setPartsUsedForRepairPrices("java.lang.String");
        job.addPartPriceToString(",");
        job.addPartPriceToString("42");
        job.getTotalRepairCost();
    }

    /**
     * Method under test: {@link Job#getTotalRepairCost()}
     */
    @Test
    void testGetTotalRepairCost10() {
        Job job = new Job();
        job.setPartsUsedForRepairPrices("42");
        job.addPartPriceToString(",");
        job.addPartPriceToString("42");
        assertEquals(84.0d, job.getTotalRepairCost());
    }

    /**
     * Method under test: {@link Job#getTotalRepairCost()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetTotalRepairCost11() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "java.util.List."
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //       at com.example.garageeindopdracht.Models.Job.getTotalRepairCost(Job.java:102)
        //   In order to prevent getTotalRepairCost()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getTotalRepairCost().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setPartsUsedForRepairPrices("java.util.List");
        job.addPartPriceToString(",");
        job.addPartPriceToString("42");
        job.getTotalRepairCost();
    }

    /**
     * Method under test: {@link Job#getTotalRepairCost()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetTotalRepairCost12() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: multiple points
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:1890)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //       at com.example.garageeindopdracht.Models.Job.getTotalRepairCost(Job.java:102)
        //   In order to prevent getTotalRepairCost()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getTotalRepairCost().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setPartsUsedForRepairPrices(",");
        job.addPartPriceToString(".");
        job.addPartPriceToString("42");
        job.getTotalRepairCost();
    }

    /**
     * Method under test: {@link Job#getTotalRepairCost()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetTotalRepairCost13() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: ".New Part Price"
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //       at com.example.garageeindopdracht.Models.Job.getTotalRepairCost(Job.java:102)
        //   In order to prevent getTotalRepairCost()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getTotalRepairCost().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setPartsUsedForRepairPrices(",");
        job.addPartPriceToString("New Part Price");
        job.addPartPriceToString("42");
        job.getTotalRepairCost();
    }

    /**
     * Method under test: {@link Job#getTotalRepairCost()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetTotalRepairCost14() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: ".null"
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //       at com.example.garageeindopdracht.Models.Job.getTotalRepairCost(Job.java:102)
        //   In order to prevent getTotalRepairCost()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getTotalRepairCost().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setPartsUsedForRepairPrices(",");
        job.addPartPriceToString(null);
        job.addPartPriceToString("42");
        job.getTotalRepairCost();
    }

    /**
     * Method under test: {@link Job#getTotalRepairCost()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetTotalRepairCost15() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: ".java.lang.String"
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //       at com.example.garageeindopdracht.Models.Job.getTotalRepairCost(Job.java:102)
        //   In order to prevent getTotalRepairCost()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getTotalRepairCost().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setPartsUsedForRepairPrices(",");
        job.addPartPriceToString("java.lang.String");
        job.addPartPriceToString("42");
        job.getTotalRepairCost();
    }

    /**
     * Method under test: {@link Job#getTotalRepairCost()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetTotalRepairCost16() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: ".java.util.List"
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //       at com.example.garageeindopdracht.Models.Job.getTotalRepairCost(Job.java:102)
        //   In order to prevent getTotalRepairCost()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getTotalRepairCost().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setPartsUsedForRepairPrices(",");
        job.addPartPriceToString("java.util.List");
        job.addPartPriceToString("42");
        job.getTotalRepairCost();
    }

    /**
     * Method under test: {@link Job#getAllParts()}
     */
    @Test
    void testGetAllParts() {
        assertTrue((new Job()).getAllParts().isEmpty());
    }

    /**
     * Method under test: {@link Job#getAllParts()}
     */
    @Test
    void testGetAllParts2() {
        Job job = new Job();
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        List<Part> actualAllParts = job.getAllParts();
        assertEquals(1, actualAllParts.size());
        Part getResult = actualAllParts.get(0);
        assertEquals("Parts Used For Repair", getResult.getPartName());
        assertEquals("Parts Used For Repair Prices", getResult.getPartPrice());
    }

    /**
     * Method under test: {@link Job#getAllParts()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllParts3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        //       at jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //       at jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //       at jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        //       at java.util.Objects.checkIndex(Objects.java:359)
        //       at java.util.ArrayList.get(ArrayList.java:427)
        //       at com.example.garageeindopdracht.Models.Job.getAllParts(Job.java:120)
        //   In order to prevent getAllParts()
        //   from throwing IndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAllParts().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.addPartToString("New Part");
        job.getAllParts();
    }

    /**
     * Method under test: {@link Job#getAllPartsAndPricesAsString()}
     */
    @Test
    void testGetAllPartsAndPricesAsString() {
        assertEquals("Part                    Price\n------------------------------\n\n\nTotal:                  0.0",
                (new Job()).getAllPartsAndPricesAsString());
    }

    /**
     * Method under test: {@link Job#getAllPartsAndPricesAsString()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllPartsAndPricesAsString2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "Parts Used For Repair Prices"
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //       at com.example.garageeindopdracht.Models.Job.getTotalRepairCost(Job.java:102)
        //       at com.example.garageeindopdracht.Models.Job.getAllPartsAndPricesAsString(Job.java:142)
        //   In order to prevent getAllPartsAndPricesAsString()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAllPartsAndPricesAsString().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        job.getAllPartsAndPricesAsString();
    }

    /**
     * Method under test: {@link Job#getAllPartsAndPricesAsString()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllPartsAndPricesAsString3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        //       at jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //       at jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //       at jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        //       at java.util.Objects.checkIndex(Objects.java:359)
        //       at java.util.ArrayList.get(ArrayList.java:427)
        //       at com.example.garageeindopdracht.Models.Job.getAllParts(Job.java:120)
        //       at com.example.garageeindopdracht.Models.Job.getAllPartsAndPricesAsString(Job.java:132)
        //   In order to prevent getAllPartsAndPricesAsString()
        //   from throwing IndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAllPartsAndPricesAsString().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.addPartToString("Part                    Price\n------------------------------\n\n");
        job.getAllPartsAndPricesAsString();
    }

    /**
     * Method under test: {@link Job#getAllPartsAndPricesAsString()}
     */
    @Test
    void testGetAllPartsAndPricesAsString4() {
        Job job = new Job();
        job.addPartPriceToString("42");
        assertEquals("Part                    Price\n------------------------------\n\n\nTotal:                  42.0",
                job.getAllPartsAndPricesAsString());
    }

    /**
     * Method under test: {@link Job#getAllPartsAndPricesAsString()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllPartsAndPricesAsString5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "."
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //       at com.example.garageeindopdracht.Models.Job.getTotalRepairCost(Job.java:102)
        //       at com.example.garageeindopdracht.Models.Job.getAllPartsAndPricesAsString(Job.java:142)
        //   In order to prevent getAllPartsAndPricesAsString()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAllPartsAndPricesAsString().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.addPartPriceToString(",");
        job.addPartPriceToString("42");
        job.getAllPartsAndPricesAsString();
    }

    /**
     * Method under test: {@link Job#getAllPartsAndPricesAsString()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllPartsAndPricesAsString6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: multiple points
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:1890)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //       at com.example.garageeindopdracht.Models.Job.getTotalRepairCost(Job.java:102)
        //       at com.example.garageeindopdracht.Models.Job.getAllPartsAndPricesAsString(Job.java:142)
        //   In order to prevent getAllPartsAndPricesAsString()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAllPartsAndPricesAsString().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setPartsUsedForRepairPrices(",");
        job.addPartPriceToString(",");
        job.addPartPriceToString("42");
        job.getAllPartsAndPricesAsString();
    }

    /**
     * Method under test: {@link Job#getAllPartsAndPricesAsString()}
     */
    @Test
    void testGetAllPartsAndPricesAsString7() {
        Job job = new Job();
        job.setPartsUsedForRepairPrices(",");
        job.addPartPriceToString("42");
        assertEquals("Part                    Price\n------------------------------\n\n\nTotal:                  0.42",
                job.getAllPartsAndPricesAsString());
    }

    /**
     * Method under test: {@link Job#getAllPartsAndPricesAsString()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllPartsAndPricesAsString8() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "Part                    Price
        //   ------------------------------
        //   ."
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //       at com.example.garageeindopdracht.Models.Job.getTotalRepairCost(Job.java:102)
        //       at com.example.garageeindopdracht.Models.Job.getAllPartsAndPricesAsString(Job.java:142)
        //   In order to prevent getAllPartsAndPricesAsString()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAllPartsAndPricesAsString().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setPartsUsedForRepairPrices("Part                    Price\n------------------------------\n\n");
        job.addPartPriceToString(",");
        job.addPartPriceToString("42");
        job.getAllPartsAndPricesAsString();
    }

    /**
     * Method under test: {@link Job#getAllPartsAndPricesAsString()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllPartsAndPricesAsString9() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: multiple points
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:1890)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //       at com.example.garageeindopdracht.Models.Job.getTotalRepairCost(Job.java:102)
        //       at com.example.garageeindopdracht.Models.Job.getAllPartsAndPricesAsString(Job.java:142)
        //   In order to prevent getAllPartsAndPricesAsString()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAllPartsAndPricesAsString().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setPartsUsedForRepairPrices(".");
        job.addPartPriceToString(",");
        job.addPartPriceToString("42");
        job.getAllPartsAndPricesAsString();
    }

    /**
     * Method under test: {@link Job#getAllPartsAndPricesAsString()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllPartsAndPricesAsString10() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "Parts Used For Repair Prices."
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //       at com.example.garageeindopdracht.Models.Job.getTotalRepairCost(Job.java:102)
        //       at com.example.garageeindopdracht.Models.Job.getAllPartsAndPricesAsString(Job.java:142)
        //   In order to prevent getAllPartsAndPricesAsString()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAllPartsAndPricesAsString().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.addPartPriceToString(",");
        job.addPartPriceToString("42");
        job.getAllPartsAndPricesAsString();
    }

    /**
     * Method under test: {@link Job#getAllPartsAndPricesAsString()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllPartsAndPricesAsString11() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "java.lang.String."
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //       at com.example.garageeindopdracht.Models.Job.getTotalRepairCost(Job.java:102)
        //       at com.example.garageeindopdracht.Models.Job.getAllPartsAndPricesAsString(Job.java:142)
        //   In order to prevent getAllPartsAndPricesAsString()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAllPartsAndPricesAsString().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setPartsUsedForRepairPrices("java.lang.String");
        job.addPartPriceToString(",");
        job.addPartPriceToString("42");
        job.getAllPartsAndPricesAsString();
    }

    /**
     * Method under test: {@link Job#getAllPartsAndPricesAsString()}
     */
    @Test
    void testGetAllPartsAndPricesAsString12() {
        Job job = new Job();
        job.setPartsUsedForRepairPrices("42");
        job.addPartPriceToString(",");
        job.addPartPriceToString("42");
        assertEquals("Part                    Price\n------------------------------\n\n\nTotal:                  84.0",
                job.getAllPartsAndPricesAsString());
    }

    /**
     * Method under test: {@link Job#getAllPartsAndPricesAsString()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllPartsAndPricesAsString13() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "java.util.List."
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //       at com.example.garageeindopdracht.Models.Job.getTotalRepairCost(Job.java:102)
        //       at com.example.garageeindopdracht.Models.Job.getAllPartsAndPricesAsString(Job.java:142)
        //   In order to prevent getAllPartsAndPricesAsString()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAllPartsAndPricesAsString().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setPartsUsedForRepairPrices("java.util.List");
        job.addPartPriceToString(",");
        job.addPartPriceToString("42");
        job.getAllPartsAndPricesAsString();
    }

    /**
     * Method under test: {@link Job#getAllPartsAndPricesAsString()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllPartsAndPricesAsString14() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: ".Part                    Price
        //   ------------------------------"
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //       at com.example.garageeindopdracht.Models.Job.getTotalRepairCost(Job.java:102)
        //       at com.example.garageeindopdracht.Models.Job.getAllPartsAndPricesAsString(Job.java:142)
        //   In order to prevent getAllPartsAndPricesAsString()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAllPartsAndPricesAsString().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setPartsUsedForRepairPrices(",");
        job.addPartPriceToString("Part                    Price\n------------------------------\n\n");
        job.addPartPriceToString("42");
        job.getAllPartsAndPricesAsString();
    }

    /**
     * Method under test: {@link Job#getAllPartsAndPricesAsString()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllPartsAndPricesAsString15() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: multiple points
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:1890)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //       at com.example.garageeindopdracht.Models.Job.getTotalRepairCost(Job.java:102)
        //       at com.example.garageeindopdracht.Models.Job.getAllPartsAndPricesAsString(Job.java:142)
        //   In order to prevent getAllPartsAndPricesAsString()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAllPartsAndPricesAsString().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setPartsUsedForRepairPrices(",");
        job.addPartPriceToString(".");
        job.addPartPriceToString("42");
        job.getAllPartsAndPricesAsString();
    }

    /**
     * Method under test: {@link Job#getAllPartsAndPricesAsString()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllPartsAndPricesAsString16() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: ".New Part Price"
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //       at com.example.garageeindopdracht.Models.Job.getTotalRepairCost(Job.java:102)
        //       at com.example.garageeindopdracht.Models.Job.getAllPartsAndPricesAsString(Job.java:142)
        //   In order to prevent getAllPartsAndPricesAsString()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAllPartsAndPricesAsString().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setPartsUsedForRepairPrices(",");
        job.addPartPriceToString("New Part Price");
        job.addPartPriceToString("42");
        job.getAllPartsAndPricesAsString();
    }

    /**
     * Method under test: {@link Job#getAllPartsAndPricesAsString()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllPartsAndPricesAsString17() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: ".null"
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //       at com.example.garageeindopdracht.Models.Job.getTotalRepairCost(Job.java:102)
        //       at com.example.garageeindopdracht.Models.Job.getAllPartsAndPricesAsString(Job.java:142)
        //   In order to prevent getAllPartsAndPricesAsString()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAllPartsAndPricesAsString().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setPartsUsedForRepairPrices(",");
        job.addPartPriceToString(null);
        job.addPartPriceToString("42");
        job.getAllPartsAndPricesAsString();
    }

    /**
     * Method under test: {@link Job#getAllPartsAndPricesAsString()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllPartsAndPricesAsString18() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: ".java.lang.String"
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //       at com.example.garageeindopdracht.Models.Job.getTotalRepairCost(Job.java:102)
        //       at com.example.garageeindopdracht.Models.Job.getAllPartsAndPricesAsString(Job.java:142)
        //   In order to prevent getAllPartsAndPricesAsString()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAllPartsAndPricesAsString().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setPartsUsedForRepairPrices(",");
        job.addPartPriceToString("java.lang.String");
        job.addPartPriceToString("42");
        job.getAllPartsAndPricesAsString();
    }

    /**
     * Method under test: {@link Job#getAllPartsAndPricesAsString()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllPartsAndPricesAsString19() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: ".java.util.List"
        //       at jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
        //       at jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //       at java.lang.Double.parseDouble(Double.java:651)
        //       at com.example.garageeindopdracht.Models.Job.getPartPricesListDouble(Job.java:92)
        //       at com.example.garageeindopdracht.Models.Job.getTotalRepairCost(Job.java:102)
        //       at com.example.garageeindopdracht.Models.Job.getAllPartsAndPricesAsString(Job.java:142)
        //   In order to prevent getAllPartsAndPricesAsString()
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAllPartsAndPricesAsString().
        //   See https://diff.blue/R013 to resolve this issue.

        Job job = new Job();
        job.setPartsUsedForRepairPrices(",");
        job.addPartPriceToString("java.util.List");
        job.addPartPriceToString("42");
        job.getAllPartsAndPricesAsString();
    }

    /**
     * Method under test: {@link Job#getStatusToString()}
     */
    @Test
    void testGetStatusToString() {
        assertEquals("Not active", (new Job()).getStatusToString());
    }

    /**
     * Method under test: {@link Job#getStatusToString()}
     */
    @Test
    void testGetStatusToString2() {
        Job job = new Job();
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(1);
        assertEquals("Active", job.getStatusToString());
    }

    /**
     * Method under test: {@link Job#getStatusToString()}
     */
    @Test
    void testGetStatusToString3() {
        Job job = new Job();
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(2);
        assertEquals("Finished", job.getStatusToString());
    }

    /**
     * Method under test: {@link Job#getStatusToString()}
     */
    @Test
    void testGetStatusToString4() {
        Job job = new Job();
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(3);
        assertEquals("Concluded", job.getStatusToString());
    }

    /**
     * Method under test: {@link Job#getStatusToString()}
     */
    @Test
    void testGetStatusToString5() {
        Job job = new Job();
        job.setCarLicensePlate("Car License Plate");
        job.setCustomerName("Customer Name");
        job.setCustomerPhoneNumber("4105551212");
        job.setJobDescription("Job Description");
        job.setJobID(1L);
        job.setPartsUsedForRepair("Parts Used For Repair");
        job.setPartsUsedForRepairPrices("Parts Used For Repair Prices");
        job.setStatus(-1);
        assertEquals("Status not found", job.getStatusToString());
    }
}

