package fr.github.jntakpe.battlecode.dodo;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Objects;

/**
 * @author jntakpe
 */
public class DodoLang {

    private String dodo;

    private String operation;

    public DodoLang(String dodo, String operation) {
        this.dodo = dodo;
        this.operation = operation;
    }

    public String getDodo() {
        return dodo;
    }

    public void setDodo(String dodo) {
        this.dodo = dodo;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DodoLang)) {
            return false;
        }
        DodoLang dodoLang = (DodoLang) o;
        return Objects.equals(dodo, dodoLang.dodo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dodo);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("dodo", dodo)
                .append("operation", operation)
                .toString();
    }
}
