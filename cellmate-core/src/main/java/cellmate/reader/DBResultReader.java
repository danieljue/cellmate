package cellmate.reader;

import cellmate.cell.Tuple;
import com.google.common.annotations.Beta;
import com.google.common.collect.ImmutableList;

import javax.naming.OperationNotSupportedException;

/**
 * User: bfemiano
 * Date: 8/27/12
 * Time: 12:15 AM
 */
@Beta
public interface DBResultReader<D, C> {

    public ImmutableList<Tuple<C>> read(Iterable<D> dbItems, QueryParameters parameters);

    public ImmutableList<Tuple<C>> read(Iterable<D> dbItems, QueryParameters parameters, CellTransformer<D,C> transformer);
}
