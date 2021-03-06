package by.it.vasiliuk.calc;

public class Scalar extends Var {
    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value){
        this.value = value;
    }

    Scalar(String value) {
        this.value = Double.parseDouble(value);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }


    @Override
    public Var add(Var other) throws CalcException {
        if(other instanceof Scalar)
            return new Scalar(this.value+((Scalar) other).value);
        else return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if(other instanceof Scalar)
            return new Scalar(this.value -((Scalar) other).value);
        Scalar minus = new Scalar(-1);
        return other.sub(this).mul(minus);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if(other instanceof Scalar)
            return new Scalar(this.value *((Scalar) other).value);
        else return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if(other instanceof Scalar) {
            if (((Scalar) other).value == 0) throw new CalcException("Division by zero.");
            return new Scalar(this.value / ((Scalar) other).value);
        }
        else  return super.div(other);
    }
}