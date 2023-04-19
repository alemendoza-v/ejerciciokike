package goldie.ejercicio1.vo;

import java.util.Objects;

import goldie.ejercicio1.enums.MetricType;

public class MetricVO {
    private double value;
    private MetricType type;

    public MetricVO() {
    }

    public MetricVO(double value, MetricType type) {
        this.value = value;
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public MetricType getType() {
        return type;
    }

    public void setType(MetricType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MetricVO other = (MetricVO) obj;
        if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
            return false;
        if (type != other.type)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, value);
    }
}
