public class TimeMeasure {
    private long _startTime;
    private long _endTime;

    public void Start(){
        _startTime = System.nanoTime();
    }

    public void End(){
        _endTime = System.nanoTime();
    }

    public long GetElapsedTime(){
        return (_endTime - _startTime);
    }
}
