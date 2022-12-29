import com.telerikacademy.core.TaskManagementEngineImpl;

public class Startup {
    public static void main(String[] args) {
        TaskManagementEngineImpl engine = new TaskManagementEngineImpl();
        engine.start();
    }
}

//CreateCompany TelerikAcademyFurniture 1337855391
//CreateBug "Bug On Board" "The Bug is doing something wrong" "High" "Critical" "Do one, Do two, Do three"