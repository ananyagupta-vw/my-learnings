package LLD.L5_observer_design_pattern;
// Observer design pattern is a type of behavioral design pattern in which an object (observable/ subject/ publisher)
// maintains a list of dependents (observers/ subscribers) and notifies them when there is a change in the state of the observable object.

// This pattern is used to implement distributed event handling systems.

// Push Model - The observable pushes updates to all observers whenever there is a change in its state.
// Pull Model - The observers pull updates from the observable whenever they need to know the state of the observable.

import java.util.ArrayList;
import java.util.List;

public class WeatherStationApp {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        Observer mobileObserver = new MobileObserver();
        Observer tvObserver = new TVObserver();

        weatherStation.addObserver(mobileObserver);
        weatherStation.addObserver(tvObserver);

        weatherStation.setTemperature(30.5f);
        weatherStation.setTemperature(32.0f);
        weatherStation.removeObserver(tvObserver);

        weatherStation.setTemperature(28.0f);
    }
}


interface Observer {
    void update(float temperature);
}

interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Concrete Observer
class MobileObserver implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("Mobile Observer: Temperature updated to " + temperature);
    }
}

class TVObserver implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("TV Observer: Temperature updated to " + temperature);
    }
}

// Concrete Observable
class WeatherStation implements Observable {
    float temperature;
    List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer){
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    void setTemperature(float temperature){
        this.temperature = temperature;
        notifyObservers(); // automatically notify observers when temperature changes
    }

    @Override
    public void notifyObservers(){
        for(Observer observer : observers){
            observer.update(temperature);
        }
    }
}

