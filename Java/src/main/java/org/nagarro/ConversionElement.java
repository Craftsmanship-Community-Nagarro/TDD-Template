package org.nagarro;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

public class ConversionElement implements Serializable {

  private final long serialVersionUID = 83838L;

  private final Currency from;
  private final Currency to;

  public ConversionElement(Currency from, Currency to) {
    this.from = from;
    this.to = to;
  }

  public Currency getFrom() {
    return from;
  }

  public Currency getTo() {
    return to;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ConversionElement that = (ConversionElement) o;
    return from == that.from && to == that.to;
  }

  @Override
  public int hashCode() {
    return Objects.hash(from, to);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", ConversionElement.class.getSimpleName() + "[", "]")
            .add("from=" + from)
            .add("to=" + to)
            .toString();
  }
}
