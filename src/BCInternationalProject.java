import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class BCInternationalProject {

    public static void main(String args[]) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/InternationalStudentInformationSystem?serverTimezone=UTC&useSSL=TRUE";

            System.out.println("*****************************************************************************");
            System.out.println("                              ***********");
            System.out.println("                            Welcome to the");
            System.out.println("                International Student Information System");
            System.out.println("                              ***********");
            System.out.println("*****************************************************************************");

            String user, pass;
            user = readEntry("Enter User ID: ");
            pass = readEntry("Enter password: ");
            conn = DriverManager.getConnection(url, user, pass);

            boolean done = false;
            do {
                printMenu();
                System.out.print("Type in your option: ");
                System.out.flush();
                String ch1 = readLine();
                System.out.println();
                switch (ch1.charAt(0)) {
                    case '1':
                        currentStudents(conn);
                        break;
                    case '2':
                        graduatedStudents(conn);
                        break;
                    case '3':
                        international(conn);
                        break;
                    case '4':
                        printUpdatesMenu();
                        System.out.print("Type in your option: ");
                        System.out.flush();
                        String ch2 = readLine();
                        System.out.println();
                        switch (ch2.charAt(0)) {
                            case '1':
                                printInsertMenu();
                                System.out.print("Type in your option: ");
                                System.out.flush();
                                String ch3 = readLine();
                                System.out.println();
                                switch (ch3.charAt(0)) {
                                    case '1':
                                        insertAddStudent(conn);
                                        break;
                                    case '2':
                                        insertAddCourse(conn);
                                        break;
                                    case '3':
                                        insertAddDepartment(conn);
                                        break;
                                    case '4':
                                        insertRegisterStudentACourse(conn);
                                        break;
                                }
                                break;
                            case '2':
                                printDeleteMenu();
                                System.out.print("Type in your option: ");
                                System.out.flush();
                                String ch4 = readLine();
                                System.out.println();
                                switch (ch4.charAt(0)) {
                                    case '1':
                                        deleteStudent(conn);
                                        break;
                                    case '2':
                                        deleteCourse(conn);
                                        break;
                                    case '3':
                                        deleteDepartment(conn);
                                        break;
                                    case '4':
                                        withdrawStudentACourse(conn);
                                        break;
                                }
                                break;
                            case '3':
                                printUpdateMenu();
                                System.out.print("Type in your option: ");
                                System.out.flush();
                                String ch5 = readLine();
                                System.out.println();
                                switch (ch5.charAt(0)) {
                                    case '1':
                                        updateStudent(conn);
                                        break;
                                    case '2':
                                        updateCourse(conn);
                                        break;
                                    case '3':
                                        updateDepartment(conn);
                                        break;
                                    case '4':
                                        updateStudentCourseRegistration(conn);
                                        break;
                                }
                                break;
                        }
                        break;
                    case '5': done = true;
                        break;
                    default:
                        System.out.println(" Not a valid option ");
                } //switch
            } while (!done);

        } catch (ClassNotFoundException e) {
            System.out.println("Could not load the driver");
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }
    }



    // ############# OTHER PARTS OF INTERFACE #############



    private static void currentStudents(Connection conn) throws SQLException, IOException {
        //Statement selectStatement = conn.createStatement();
        //String query = "";
        //ResultSet selectResult = selectStatement.executeQuery(query);

        System.out.println("Current Students:");
        System.out.println("--------------------------------------------------\n");

        //while(selectResult.next()) {
        //    String #### = selectResult.getString(###);
        //    System.out.println("###: " + ####);
        //}
    }

    private static void graduatedStudents(Connection conn) throws SQLException, IOException {
        //Statement selectStatement = conn.createStatement();
        //String query = "";
        //ResultSet selectResult = selectStatement.executeQuery(query);

        System.out.println("Graduated Students:");
        System.out.println("--------------------------------------------------\n");

        //while(selectResult.next()) {
        //    String #### = selectResult.getString(###);
        //    System.out.println("###: " + ####);
        //}
    }

    private static void international(Connection conn) throws SQLException, IOException {
        //Statement selectStatement = conn.createStatement();
        //String query = "";
        //ResultSet selectResult = selectStatement.executeQuery(query);

        System.out.println("International Rules & Laws:");
        System.out.println("--------------------------------------------------\n");

        //while(selectResult.next()) {
        //    String #### = selectResult.getString(###);
        //    System.out.println("###: " + ####);
        //}
    }



    // ############# OPTION A #############



    private static void insertAddStudent(Connection conn) throws SQLException, IOException {
    	
        System.out.println("Add new student information:");
        System.out.println("--------------------------------------------------\n");

        String ssn, name, gender, birthday, address, enrollDate, visaType, majorDepartmentID, nationality, answer;
        boolean isUndergraduate = false, isGraduate = false;
        System.out.print("Is this new student undergraduate? Answer[Y/N]");
        System.out.flush();
        answer = readLine();
        System.out.println();
        if (answer.charAt(0) == 'Y')
        {
        	isUndergraduate = true;
        }
        else 
        {
            System.out.print("Is this new student graduate? Answer[Y/N]");
            System.out.flush();
            answer = readLine();
            System.out.println();
            if (answer.charAt(0) == 'Y')
            {
            	isGraduate = true;
            }
            else 
            {
            	System.out.print("ERROR: A student needs to be either Undergraduate or Graduate.");
            	return;
            }
        }
        
        System.out.print("Type in new Student SSN: ");
        System.out.flush();
        ssn = readLine();
        System.out.println();
        
        System.out.print("Type in new Student name: ");
        System.out.flush();
        name = readLine();
        System.out.println();
        
        System.out.print("Type in new Student gender: ");
        System.out.flush();
        gender = readLine();
        System.out.println();
        
        System.out.print("Type in new Student birthday: ");
        System.out.flush();
        birthday = readLine();
        System.out.println();
        
        System.out.print("Type in new Student address: ");
        System.out.flush();
        address = readLine();
        System.out.println();
        
        System.out.print("Type in new Student enroll date: ");
        System.out.flush();
        enrollDate = readLine();
        System.out.println();
        
        System.out.print("Type in new Student visa type: ");
        System.out.flush();
        visaType = readLine();
        System.out.println();
        
        System.out.print("Type in new Student major department ID: ");
        System.out.flush();
        majorDepartmentID = readLine();
        System.out.println();
        
        System.out.print("Type in new Student nationality: ");
        System.out.flush();
        nationality = readLine();
        System.out.println();
        
        Statement stmt = conn.createStatement();
        String command = "INSERT INTO Student Value (" + ssn + ",\"" + name + "\",\"" + gender + "\",\"" + birthday + "\",\"" + address + "\",\"" + enrollDate + "\",\"" + visaType + "\"," + majorDepartmentID + ",\"" + nationality + "\",3)";
        try 
        {
        	stmt.executeUpdate(command);

        	if (isUndergraduate)
        	{
        		command = "INSERT INTO UndergraduateStudent Value (" + ssn + ",1)";
        	}
        	
        	if (isGraduate)
        	{
        		command = "INSERT INTO GraduateStudent Value (" + ssn + ",2)";
        	}
        	
    		stmt.executeUpdate(command);
        	System.out.println("Insertion succeeds.");
        	System.out.println("--------------------------------------------------\n");
        }
        catch (SQLException e) {
        	System.out.println(e.toString());
        	System.out.println("Insertion fails.");
        	System.out.println("--------------------------------------------------\n");
        }   
    }

    private static void insertAddCourse(Connection conn) throws SQLException, IOException {
    	
        System.out.println("Add new course information:");
        System.out.println("--------------------------------------------------\n");
        
        String courseID, name, numberOfCredits, departmentID;
        System.out.print("Type in new Course ID: ");
        System.out.flush();
        courseID = readLine();
        System.out.println();
        
        System.out.print("Type in new Course name: ");
        System.out.flush();
        name = readLine();
        System.out.println();
        
        System.out.print("Type in new Course's number of Credits: ");
        System.out.flush();
        numberOfCredits = readLine();
        System.out.println();
        
        System.out.print("Type in new Course's department ID: ");
        System.out.flush();
        departmentID = readLine();
        System.out.println();
        
        Statement stmt = conn.createStatement();
        String command = "INSERT INTO Course Value (" + courseID + ",\"" + name + "\"," + numberOfCredits + "," + departmentID + ")";
        try 
        {
        	stmt.executeUpdate(command);
        	System.out.println("Insertion succeeds.");
        	System.out.println("--------------------------------------------------\n");
        }
        catch (SQLException e) {
        	System.out.println(e.toString());
        	System.out.println("Insertion fails.");
        	System.out.println("--------------------------------------------------\n");
        }   
    }

    private static void insertAddDepartment(Connection conn) throws SQLException, IOException {

        System.out.println("Add new department information:");
        System.out.println("--------------------------------------------------\n");
        
        String departmentID, name, address, headName,headAddress,collegeID;
        System.out.print("Type in new Department ID: ");
        System.out.flush();
        departmentID = readLine();
        System.out.println();
        
        System.out.print("Type in new Department name: ");
        System.out.flush();
        name = readLine();
        System.out.println();

        System.out.print("Type in new Department address: ");
        System.out.flush();
        address = readLine();
        System.out.println();
        
        System.out.print("Type in new Department headName: ");
        System.out.flush();
        headName = readLine();
        System.out.println();

        System.out.print("Type in new Department headAddresss: ");
        System.out.flush();
        headAddress = readLine();
        System.out.println();
        
        System.out.print("Type in new Department collegeID: ");
        System.out.flush();
        collegeID = readLine();
        System.out.println();
        
        Statement stmt = conn.createStatement();
        String command = "INSERT INTO Department Value(" + departmentID + ",\"" + name +"\",\"" + address +"\",\"" + headName +"\",\"" + headAddress +"\"," + collegeID +")";
        try 
        {
        	stmt.executeUpdate(command);
        	System.out.println("Insertion succeeds.");
        	System.out.println("--------------------------------------------------\n");
        }
        catch (SQLException e) {
        	System.out.println(e.toString());
        	System.out.println("Insertion fails.");
        	System.out.println("--------------------------------------------------\n");
        }  

    }

    private static void insertRegisterStudentACourse(Connection conn) throws SQLException, IOException {
        //Statement selectStatement = conn.createStatement();
        //String query = "";
        //ResultSet selectResult = selectStatement.executeQuery(query);

        System.out.println("Register a student in a course:");
        System.out.println("--------------------------------------------------\n");

        String courseID, studentSSN;
        System.out.print("Type in course ID which to be registered: ");
        System.out.flush();
        courseID = readLine();
        System.out.println();
        
        System.out.print("Type in new registrant student SSN: ");
        System.out.flush();
        studentSSN = readLine();
        System.out.println();
        
        Statement stmt = conn.createStatement();
        String command = "INSERT INTO Student_Takes_Course Value(" + courseID + "," + studentSSN + ")";
        try 
        {
        	stmt.executeUpdate(command);
        	System.out.println("Insertion succeeds.");
        	System.out.println("--------------------------------------------------\n");
        }
        catch (SQLException e) {
        	System.out.println(e.toString());
        	System.out.println("Insertion fails.");
        	System.out.println("--------------------------------------------------\n");
        }
        
        
        ResultSet rset;
        int totalCreditsTaken, isUndergraduate, isGraduate;
        
        try {
        	command = "select Sum(NumberOfCredits) as TotalCredits from Student_Takes_Course inner join Course On Student_Takes_Course.CourseID = Course.CourseID where StudentSSN = " + studentSSN;
            rset = stmt.executeQuery(command);
            rset.next();
            totalCreditsTaken = rset.getInt(1);
            
            command = "select count(Regulation_ID_Minimum_Credits) from UndergraduateStudent where SSN = " + studentSSN + " and Regulation_ID_Minimum_Credits = 1";
            rset = stmt.executeQuery(command);
            rset.next();
            isUndergraduate = rset.getInt(1);
            
            command = "select count(Regulation_ID_Minimum_Credits) from GraduateStudent where SSN = " + studentSSN + " and Regulation_ID_Minimum_Credits = 2";
            rset = stmt.executeQuery(command);
            rset.next();
            isGraduate = rset.getInt(1);
            
            if (isUndergraduate == 1 && totalCreditsTaken < 12)
            {
            	System.out.println("This student has still too few credits to meet the Minimum Credits Per Semester Regulation for International Undergraduate Students.");
            }
            else if (isGraduate == 1 && totalCreditsTaken < 9)
            {
            	System.out.println("This student has still too few credits to meet the Minimum Credits Per Semester Regulation for International Graduate Students.");
            }
        }
        catch (SQLException e) {
        	System.out.println(e.toString());
        } 
    }



    // ############# OPTION B #############



    private static void deleteStudent(Connection conn) throws SQLException, IOException {
    	
        System.out.println("Delete specific student information:");
        System.out.println("--------------------------------------------------\n");
        
        System.out.println("which student is going to be deleted?");
        System.out.print("Enter the Student's SSN: ");
        System.out.flush();
        String ssn = readLine();
        System.out.println();
        Statement stmt = conn.createStatement();
        String command = "delete from Student where SSN = " + ssn;

        try 
        {
        	int rowEffected = stmt.executeUpdate(command);
        	if (rowEffected > 0 ) 
        	{
            	System.out.println("Deletion succeeds.");
            	System.out.println("--------------------------------------------------\n");
        	}
        	else 
        	{
            	System.out.println("Deletion fails, no such student is found.");
            	System.out.println("--------------------------------------------------\n");
        	}

        }
        catch (SQLException e) {
        	System.out.println(e.toString());
        	System.out.println("Deletion fails.");
        	System.out.println("--------------------------------------------------\n");
        }   

    }

    private static void deleteCourse(Connection conn) throws SQLException, IOException {

        System.out.println("Delete specific course information:");
        System.out.println("--------------------------------------------------\n");
        
        System.out.println("which Course is going to be deleted?");
        System.out.print("Enter the Course ID: ");
        System.out.flush();
        String courseID = readLine();
        System.out.println();
        Statement stmt = conn.createStatement();
        String command = "delete from Course where CourseID = " + courseID;
        
        try 
        {
        	int rowEffected = stmt.executeUpdate(command);
        	if (rowEffected > 0 ) 
        	{
            	System.out.println("Deletion succeeds.");
            	System.out.println("--------------------------------------------------\n");
        	}
        	else 
        	{
            	System.out.println("Deletion fails, no such course is found.");
            	System.out.println("--------------------------------------------------\n");
        	}

        }
        catch (SQLException e) {
        	System.out.println(e.toString());
        	System.out.println("Deletion fails.");
        	System.out.println("--------------------------------------------------\n");
        }   

    }


    private static void deleteDepartment(Connection conn) throws SQLException, IOException {

        System.out.println("Delete department information:");
        System.out.println("--------------------------------------------------\n");
        
        System.out.println("which department is going to be deleted?");
        System.out.print("Enter the department ID: ");
        System.out.flush();
        String departmentID = readLine();
        System.out.println();
        
        Statement stmt = conn.createStatement();
        String command = "delete from Department where DepartmentID = " + departmentID;
        
        try 
        {
        	int rowEffected = stmt.executeUpdate(command);
        	if (rowEffected > 0 ) 
        	{
            	System.out.println("Deletion succeeds.");
            	System.out.println("--------------------------------------------------\n");
        	}
        	else 
        	{
            	System.out.println("Deletion fails, no such Department is found.");
            	System.out.println("--------------------------------------------------\n");
        	}

        }
        catch (SQLException e) {
        	System.out.println(e.toString());
        	System.out.println("Deletion fails.");
        	System.out.println("--------------------------------------------------\n");
        }   


    }

    private static void withdrawStudentACourse(Connection conn) throws SQLException, IOException {

        System.out.println("Withdraw a student from a course:");
        System.out.println("--------------------------------------------------\n");

        String courseID, studentSSN;
        System.out.print("Type in course ID which to be withdrawn from: ");
        System.out.flush();
        courseID = readLine();
        System.out.println();
        
        System.out.print("Type in the withdrawing student's SSN: ");
        System.out.flush();
        studentSSN = readLine();
        System.out.println();
        
        Statement stmt = conn.createStatement();
        String command = "delete from Student_Takes_Course where CourseID = " + courseID + "and StudentSSN = " + studentSSN;
        
        try 
        {
        	int rowEffected = stmt.executeUpdate(command);
        	if (rowEffected > 0 ) 
        	{
            	System.out.println("Deletion succeeds.");
            	System.out.println("--------------------------------------------------\n");
        	}
        	else 
        	{
            	System.out.println("Deletion fails, no such student-course pair is found.");
            	System.out.println("--------------------------------------------------\n");
        	}

        }
        catch (SQLException e) {
        	System.out.println(e.toString());
        	System.out.println("Deletion fails.");
        	System.out.println("--------------------------------------------------\n");
        }   
    }



    // ############# OPTION C #############



    private static void updateStudent(Connection conn) throws SQLException, IOException {

        System.out.println("Update specific student information:");
        System.out.println("--------------------------------------------------\n");
        
        String ssn, temp, answer;
        
        System.out.print("Type in Student SSN: ");
        System.out.flush();
        ssn = readLine();
        System.out.println();
        
        Statement stmt = conn.createStatement();
        String command;
        
        System.out.print("Update name? Answer[Y/N]");
        System.out.flush();
        temp = readLine();
        answer = readLine();
        System.out.println();
        if (answer.charAt(0) == 'Y')
        {
            System.out.print("Type in new Student name: ");
            System.out.flush();
            temp = readLine();
            System.out.println();
            
            command  = "update Student set Name = " + temp + " where SSN = " + ssn;
            try
            {
            	stmt.executeUpdate(command);
            	System.out.println("Update succeeds.");
            }
            catch (SQLException e)
            {
            	System.out.println(e.toString());
            	System.out.println("Update fails.");
            }
        }
        
        System.out.print("Update gender? Answer[Y/N]");
        System.out.flush();
        temp = readLine();
        answer = readLine();
        System.out.println();
        if (answer.charAt(0) == 'Y')
        {
            System.out.print("Type in new gender: ");
            System.out.flush();
            temp = readLine();
            System.out.println();
            
            command  = "update Student set Gender = " + temp + " where SSN = " + ssn;
            try
            {
            	stmt.executeUpdate(command);
            	System.out.println("Update succeeds.");
            }
            catch (SQLException e)
            {
            	System.out.println(e.toString());
            	System.out.println("Update fails.");
            }
        }
        
        System.out.print("Update birthday? Answer[Y/N]");
        System.out.flush();
        temp = readLine();
        answer = readLine();
        System.out.println();
        if (answer.charAt(0) == 'Y')
        {
            System.out.print("Type in new Student birthday: ");
            System.out.flush();
            temp = readLine();
            System.out.println();
            
            command  = "update Student set BirthDay = " + temp + " where SSN = " + ssn;
            try
            {
            	stmt.executeUpdate(command);
            	System.out.println("Update succeeds.");
            }
            catch (SQLException e)
            {
            	System.out.println(e.toString());
            	System.out.println("Update fails.");
            }
        }
        
        System.out.print("Update address? Answer[Y/N]");
        System.out.flush();
        temp = readLine();
        answer = readLine();
        System.out.println();
        if (answer.charAt(0) == 'Y')
        {
            System.out.print("Type in new Student address: ");
            System.out.flush();
            temp = readLine();
            System.out.println();
            
            command  = "update Student set Address = " + temp + " where SSN = " + ssn;
            try
            {
            	stmt.executeUpdate(command);
            	System.out.println("Update succeeds.");
            }
            catch (SQLException e)
            {
            	System.out.println(e.toString());
            	System.out.println("Update fails.");
            }
        }
        
        System.out.print("Update Enrolldate? Answer[Y/N]");
        System.out.flush();
        temp = readLine();
        answer = readLine();
        System.out.println();
        if (answer.charAt(0) == 'Y')
        {
            System.out.print("Type in new Student enrolldate: ");
            System.out.flush();
            temp = readLine();
            System.out.println();
            
            command  = "update Student set EnrollDate = " + temp + " where SSN = " + ssn;
            try
            {
            	stmt.executeUpdate(command);
            	System.out.println("Update succeeds.");
            }
            catch (SQLException e)
            {
            	System.out.println(e.toString());
            	System.out.println("Update fails.");
            }
        }
        
        System.out.print("Update visatype? Answer[Y/N]");
        System.out.flush();
        temp = readLine();
        answer = readLine();
        System.out.println();
        if (answer.charAt(0) == 'Y')
        {
            System.out.print("Type in new Student visatype: ");
            System.out.flush();
            temp = readLine();
            System.out.println();
            
            command  = "update Student set VisaType = " + temp + " where SSN = " + ssn;
            try
            {
            	stmt.executeUpdate(command);
            	System.out.println("Update succeeds.");
            }
            catch (SQLException e)
            {
            	System.out.println(e.toString());
            	System.out.println("Update fails.");
            }
        }
        
        System.out.print("Update major department ID? Answer[Y/N]");
        System.out.flush();
        temp = readLine();
        answer = readLine();
        System.out.println();
        if (answer.charAt(0) == 'Y')
        {
            System.out.print("Type in new Student major department ID: ");
            System.out.flush();
            temp = readLine();
            System.out.println();
            
            command  = "update Student set MajorDepartmentID = " + temp + " where SSN = " + ssn;
            try
            {
            	stmt.executeUpdate(command);
            	System.out.println("Update succeeds.");
            }
            catch (SQLException e)
            {
            	System.out.println(e.toString());
            	System.out.println("Update fails.");
            }
        }
        
        System.out.print("Update nationality? Answer[Y/N]");
        System.out.flush();
        temp = readLine();
        answer = readLine();
        System.out.println();
        if (answer.charAt(0) == 'Y')
        {
            System.out.print("Type in new Student nationality: ");
            System.out.flush();
            temp = readLine();
            System.out.println();
            
            command  = "update Student set Nationality = " + temp + " where SSN = " + ssn;
            try
            {
            	stmt.executeUpdate(command);
            	System.out.println("Update succeeds.");
            }
            catch (SQLException e)
            {
            	System.out.println(e.toString());
            	System.out.println("Update fails.");
            }
        }
        
    }

    private static void updateCourse(Connection conn) throws SQLException, IOException {
    	

        System.out.println("Update specific course information:");
        System.out.println("--------------------------------------------------\n");
        
        String courseID, temp, answer;
        
        System.out.print("Type in Course ID: ");
        System.out.flush();
        courseID = readLine();
        System.out.println();
        
        Statement stmt = conn.createStatement();
        String command;
        
        System.out.print("Update Name? Answer[Y/N]");
        System.out.flush();
        temp = readLine();
        answer = readLine();
        System.out.println();
        if (answer.charAt(0) == 'Y')
        {
            System.out.print("Type in new course name: ");
            System.out.flush();
            temp = readLine();
            System.out.println();
            
            command  = "update Course set Name = " + temp + " where CourseID = " + courseID;
            try
            {
            	stmt.executeUpdate(command);
            	System.out.println("Update succeeds.");
            }
            catch (SQLException e)
            {
            	System.out.println(e.toString());
            	System.out.println("Update fails.");
            }
        }
        
        System.out.print("Update Number of Credits? Answer[Y/N]");
        System.out.flush();
        temp = readLine();
        answer = readLine();
        System.out.println();
        if (answer.charAt(0) == 'Y')
        {
            System.out.print("Type in new course Number of Credits: ");
            System.out.flush();
            temp = readLine();
            System.out.println();
            
            command  = "update Course set NumberOfCredits = " + temp + " where CourseID = " + courseID;
            try
            {
            	stmt.executeUpdate(command);
            	System.out.println("Update succeeds.");
            }
            catch (SQLException e)
            {
            	System.out.println(e.toString());
            	System.out.println("Update fails.");
            }
        }
        
        System.out.print("Update Department ID? Answer[Y/N]");
        System.out.flush();
        temp = readLine();
        answer = readLine();
        System.out.println();
        if (answer.charAt(0) == 'Y')
        {
            System.out.print("Type in new Department ID: ");
            System.out.flush();
            temp = readLine();
            System.out.println();
            
            command  = "update Course set DepartmentID = " + temp + " where CourseID = " + courseID;
            try
            {
            	stmt.executeUpdate(command);
            	System.out.println("Update succeeds.");
            }
            catch (SQLException e)
            {
            	System.out.println(e.toString());
            	System.out.println("Update fails.");
            }
        }

    }

    private static void updateDepartment(Connection conn) throws SQLException, IOException {

        System.out.println("Update department information:");
        System.out.println("--------------------------------------------------\n");
        
        String department, temp, answer;
        
        System.out.print("Type in department ID: ");
        System.out.flush();
        department = readLine();
        System.out.println();
        
        Statement stmt = conn.createStatement();
        String command;
        
        System.out.print("Update department Name? Answer[Y/N]");
        System.out.flush();
        temp = readLine();
        answer = readLine();
        System.out.println();
        if (answer.charAt(0) == 'Y')
        {
            System.out.print("Type in new department name: ");
            System.out.flush();
            temp = readLine();
            System.out.println();
            
            command  = "update Department set Name = " + temp + " where DepartmentID = " + department;
            try
            {
            	stmt.executeUpdate(command);
            	System.out.println("Update succeeds.");
            }
            catch (SQLException e)
            {
            	System.out.println(e.toString());
            	System.out.println("Update fails.");
            }
        }
        
        System.out.print("Update department address? Answer[Y/N]");
        System.out.flush();
        temp = readLine();
        answer = readLine();
        System.out.println();
        if (answer.charAt(0) == 'Y')
        {
            System.out.print("Type in new department address: ");
            System.out.flush();
            temp = readLine();
            System.out.println();
            
            command  = "update Department set Address = " + temp + " where DepartmentID = " + department;
            try
            {
            	stmt.executeUpdate(command);
            	System.out.println("Update succeeds.");
            }
            catch (SQLException e)
            {
            	System.out.println(e.toString());
            	System.out.println("Update fails.");
            }
        }
        
        System.out.print("Update department headname? Answer[Y/N]");
        System.out.flush();
        temp = readLine();
        answer = readLine();
        System.out.println();
        if (answer.charAt(0) == 'Y')
        {
            System.out.print("Type in new department headname: ");
            System.out.flush();
            temp = readLine();
            System.out.println();
            
            command  = "update Department set HeadName = " + temp + " where DepartmentID = " + department;
            try
            {
            	stmt.executeUpdate(command);
            	System.out.println("Update succeeds.");
            }
            catch (SQLException e)
            {
            	System.out.println(e.toString());
            	System.out.println("Update fails.");
            }
        }
        
        System.out.print("Update department head address? Answer[Y/N]");
        System.out.flush();
        temp = readLine();
        answer = readLine();
        System.out.println();
        if (answer.charAt(0) == 'Y')
        {
            System.out.print("Type in new department head address: ");
            System.out.flush();
            temp = readLine();
            System.out.println();
            
            command  = "update Department set HeadAddress = " + temp + " where DepartmentID = " + department;
            try
            {
            	stmt.executeUpdate(command);
            	System.out.println("Update succeeds.");
            }
            catch (SQLException e)
            {
            	System.out.println(e.toString());
            	System.out.println("Update fails.");
            }
        }
        
        System.out.print("Update department college ID? Answer[Y/N]");
        System.out.flush();
        temp = readLine();
        answer = readLine();
        System.out.println();
        if (answer.charAt(0) == 'Y')
        {
            System.out.print("Type in new department college ID: ");
            System.out.flush();
            temp = readLine();
            System.out.println();
            
            command  = "update Department set CollegeID = " + temp + " where DepartmentID = " + department;
            try
            {
            	stmt.executeUpdate(command);
            	System.out.println("Update succeeds.");
            }
            catch (SQLException e)
            {
            	System.out.println(e.toString());
            	System.out.println("Update fails.");
            }
        }
        
    }

    private static void updateStudentCourseRegistration(Connection conn) throws SQLException, IOException {

        System.out.println("Update a student Course registration:");
        System.out.println("--------------------------------------------------\n");
        
        String courseID, studentSSN;
        System.out.print("Type in course ID you want to update: ");
        System.out.flush();
        courseID = readLine();
        System.out.println();
        
        System.out.print("Type in student SSN you want to update: ");
        System.out.flush();
        studentSSN = readLine();
        System.out.println();

    }

    static String readEntry(String prompt) {
        try {
            StringBuffer buffer = new StringBuffer();
            System.out.print(prompt);
            System.out.flush();
            int c = System.in.read();
            while(c != '\n' && c != -1) {
                buffer.append((char)c);
                c = System.in.read();
            }
            return buffer.toString().trim();
        } catch (IOException e) {
            return "";
        }
    }

    private static String readLine() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr, 1);
        String line = "";

        try {
            line = br.readLine();
        } catch (IOException e) {
            System.out.println("Error in SimpleIO.readLine: " +
                    "IOException was thrown");
            System.exit(1);
        }
        return line;
    }

    private static void printMenu() {
        System.out.println("                           1. Current Students");
        System.out.println("                          2. Graduated Students");
        System.out.println("                      3. International Rules & Laws");
        System.out.println("                               4. Updates");
        System.out.println("                                5. Quit");
    }

    private static void printUpdatesMenu() {
        System.out.println("                          1. Insert Information");
        System.out.println("                          2. Delete Information");
        System.out.println("                          3. Update Information");
    }

    private static void printInsertMenu() {
        System.out.println("                          1. Add new student information");
        System.out.println("                          2. Add new course information");
        System.out.println("                          3. Add new department information");
        System.out.println("                          4. Register a student in a course");
    }

    private static void printDeleteMenu() {
        System.out.println("                          1. Delete specific student information");
        System.out.println("                          2. Delete specific course information");
        System.out.println("                          3. Delete department information");
        System.out.println("                          4. Withdraw a student from a course");
    }

    private static void printUpdateMenu() {
        System.out.println("                          1. Update specific student information");
        System.out.println("                          2. Update specific course information");
        System.out.println("                          3. Update department information");
        System.out.println("                          4. Update a student Course registration");
    }
}
