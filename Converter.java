public class Converter {
    Double toKilometers(int steps) {
        return (steps  * 0.75 / 1000);
    }
    int toCalories(int steps) {
        return (steps * 50 / 1000);
    }
}

