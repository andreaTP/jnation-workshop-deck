package org.acme;

import java.io.InputStream;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WasmService {

    public void setModule(InputStream module) {
    }

    public int compute(int content) {
        return 1;
    }
}