import com.example.demo.service.ExerciseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class CommandLineAppStartupRunner implements CommandLineRunner {
    @Autowired
    private ExerciseCategoryService exerciseCategoryService;

    @Override
    public void run(String... args) {
    exerciseCategoryService.saveCategory();
    }
}
