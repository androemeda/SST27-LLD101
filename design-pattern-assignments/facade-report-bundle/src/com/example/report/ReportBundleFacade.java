package com.example.report;

import java.io.UncheckedIOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;

public class ReportBundleFacade {
    private final AuditLog al;
    private final JsonWriter jw;
    private final Zipper z;

    public ReportBundleFacade() {
        this.al = new AuditLog();
        this.jw = new JsonWriter();
        this.z = new Zipper();
    }

    public Path export(Map<String, Object> data, Path outDir, String baseName) {
        Objects.requireNonNull(data, "data cannot be null");
        Objects.requireNonNull(outDir, "outDir cannot be null");
        Objects.requireNonNull(baseName, "baseName cannot be null");
        
        try {
            Path jsonFile = jw.write(data, outDir, baseName);
            Path zipFile = outDir.resolve(baseName + ".zip");
            Path resultZip = z.zip(jsonFile, zipFile);
            al.log("exported " + resultZip);
            return resultZip;
        } catch (Exception e) {
            if (e instanceof UncheckedIOException) {
                throw e;
            }
            throw new UncheckedIOException("Failed to export report bundle", 
                e instanceof java.io.IOException ? (java.io.IOException) e : new java.io.IOException(e));
        }
    }
}
