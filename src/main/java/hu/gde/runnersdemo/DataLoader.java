package hu.gde.runnersdemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {

    private final RunnerRepository runnerRepository;
    private final ShoeRepository shoeRepository;

    @Autowired
    public DataLoader(RunnerRepository runnerRepository,ShoeRepository shoeRepository) {
        this.runnerRepository = runnerRepository;
        this.shoeRepository = shoeRepository;
    }

    @Override
    public void run(String... args) {
        ShoeEntity shoeEntity = new ShoeEntity();
        shoeEntity.setShoeName("Adidas");
        shoeRepository.save(shoeEntity);

        // create default runner entity
        RunnerEntity runnerEntity = new RunnerEntity();
        runnerEntity.setRunnerName("Tomi");
        runnerEntity.setAveragePace(310);
        runnerEntity.setRunnerAge(22);
        runnerEntity.setShoe(shoeEntity);

        // create default laptime entities and add them to the runner entity
        LapTimeEntity laptime1 = new LapTimeEntity();
        laptime1.setLapNumber(1);
        laptime1.setTimeSeconds(120);
        laptime1.setRunner(runnerEntity);

        LapTimeEntity laptime2 = new LapTimeEntity();
        laptime2.setLapNumber(2);
        laptime2.setTimeSeconds(110);
        laptime2.setRunner(runnerEntity);

        runnerEntity.getLaptimes().add(laptime1);
        runnerEntity.getLaptimes().add(laptime2);

        runnerRepository.save(runnerEntity);

        ShoeEntity shoeEntity2 = new ShoeEntity();
        shoeEntity2.setShoeName("Nike");
        shoeRepository.save(shoeEntity2);

        RunnerEntity runnerEntity2 = new RunnerEntity();
        runnerEntity2.setRunnerName("Zsuzsi");
        runnerEntity2.setAveragePace(290);
        runnerEntity2.setRunnerAge(19);
        runnerEntity2.setShoe(shoeEntity2);

        // create default laptime entities and add them to the runner entity
        LapTimeEntity laptime3 = new LapTimeEntity();
        laptime3.setLapNumber(1);
        laptime3.setTimeSeconds(95);
        laptime3.setRunner(runnerEntity2);

        LapTimeEntity laptime4 = new LapTimeEntity();
        laptime4.setLapNumber(2);
        laptime4.setTimeSeconds(100);
        laptime4.setRunner(runnerEntity2);

        runnerEntity2.getLaptimes().add(laptime3);
        runnerEntity2.getLaptimes().add(laptime4);

        runnerRepository.save(runnerEntity2);

        ShoeEntity shoeEntity3 = new ShoeEntity();
        shoeEntity3.setShoeName("Reebok");
        shoeRepository.save(shoeEntity3);

        RunnerEntity runnerEntity3 = new RunnerEntity();
        runnerEntity3.setRunnerName("Norbi");
        runnerEntity3.setAveragePace(250);
        runnerEntity3.setRunnerAge(26);
        runnerEntity3.setShoe(shoeEntity3);

        LapTimeEntity laptime5 = new LapTimeEntity();
        laptime5.setLapNumber(1);
        laptime5.setTimeSeconds(100);
        laptime5.setRunner(runnerEntity3);

        LapTimeEntity laptime6 = new LapTimeEntity();
        laptime6.setLapNumber(2);
        laptime6.setTimeSeconds(120);
        laptime6.setRunner(runnerEntity3);

        runnerEntity3.getLaptimes().add(laptime5);
        runnerEntity3.getLaptimes().add(laptime6);

        runnerRepository.save(runnerEntity3);
    }
}

