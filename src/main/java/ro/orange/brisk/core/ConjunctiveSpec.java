package ro.orange.brisk.core;

import java.util.ArrayList;
import java.util.List;

//AND separated specs
public class ConjunctiveSpec<T> implements ISpec<T> {

    List<ISpec<T>> specs = new ArrayList<>();

    public ConjunctiveSpec() {
    }

    public ConjunctiveSpec<T> add(ISpec<T> spec) {
        specs.add(spec);
        return this;
    }

    public Boolean isSatisfiedBy(T input) {
        if (null == input) return false;
        Boolean eval = true;
        for (ISpec<T> spec : specs)
            eval = eval && spec.isSatisfiedBy(input);
        return eval;
    }
}
