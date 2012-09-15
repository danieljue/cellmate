package cellmate.accumulo.cell;

import cellmate.cell.*;

/**
 * User: bfemiano
 * Date: 9/12/12
 * Time: 12:01 AM
 */
@Cell
public class SecurityDoubleValueCell {

    @Label
    private String label;

    @Value
    private double value;

    @CellAuxilaryField(name="colvis")
    private String colVis;

    @CellAuxilaryField(name="timestamp")
    private long timestamp;

    @ColumnFamily
    private String colFam;

    public SecurityDoubleValueCell(String label, double value) {
        this.label = label;
        this.value = value;
    }

    public SecurityDoubleValueCell(String label, double value, String colfam) {
        this(label, value);
        this.colFam = colfam;
    }

    public SecurityDoubleValueCell(String label, double value, long timestamp) {
        this(label, value);
        this.timestamp = timestamp;
    }

    public SecurityDoubleValueCell(String label, double value, long timestamp, String colVis) {
        this(label, value ,timestamp);
        this.colVis = colVis;
    }

    public SecurityDoubleValueCell(String label, double value, long timestamp, String colVis, String colFam) {
        this(label, value ,timestamp, colVis);
        this.colFam = colFam;
    }
}