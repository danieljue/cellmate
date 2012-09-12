package cellmate.accumulo.reader;

import cellmate.accumulo.parameters.AccumuloParameters;
import cellmate.cell.CellGroup;
import cellmate.cell.parameters.Parameters;
import cellmate.reader.AggregateCellGroupingDBResultReader;
import cellmate.reader.BasicCellGroupingDBResultReader;
import cellmate.reader.CellTransformer;
import cellmate.reader.DBResultReader;
import com.google.common.annotations.VisibleForTesting;
import org.apache.accumulo.core.client.Instance;
import org.apache.accumulo.core.client.ZooKeeperInstance;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Value;

import java.util.List;
import java.util.Map;

/**
 * User: bfemiano
 * Date: 9/12/12
 * Time: 1:04 AM
 */
public class AccumuloAggregateDBResultReader<C>
        implements DBResultReader<Map.Entry<Key,Value>,C> {

    private AccumuloDBResultReader<C> coreResultReader;

    @VisibleForTesting
    public AccumuloAggregateDBResultReader(Instance instance){
        coreResultReader = new AccumuloDBResultReader<C>(
                new AggregateCellGroupingDBResultReader<Map.Entry<Key, Value>, C>(),
                instance);
    }

    public AccumuloAggregateDBResultReader(AccumuloParameters parameters){
        coreResultReader = new AccumuloDBResultReader<C>(
                new AggregateCellGroupingDBResultReader<Map.Entry<Key, Value>, C>(),
                parameters);
    }



    public AccumuloAggregateDBResultReader(String instanceName, String zookeepers){
        coreResultReader = new AccumuloDBResultReader<C>(
                new AggregateCellGroupingDBResultReader<Map.Entry<Key, Value>, C>(),
                instanceName,
                zookeepers);
    }


    public List<CellGroup<C>> read(Iterable<Map.Entry<Key, Value>> dbItems,
                                   Parameters parameters, CellTransformer<Map.Entry<Key, Value>, C> transformer) {
         return coreResultReader.read(dbItems, parameters, transformer);
    }

    public List<CellGroup<C>> read(Parameters parameters, CellTransformer<Map.Entry<Key, Value>, C> transformer) {
        return coreResultReader.read(parameters, transformer);
    }
}
