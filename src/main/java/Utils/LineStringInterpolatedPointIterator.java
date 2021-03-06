package Utils;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.LineSegment;
import com.vividsolutions.jts.geom.LineString;

import java.util.Iterator;

/**
 * Created by Artyom.Fomenko on 19.07.2016
 */
public class LineStringInterpolatedPointIterator implements Iterator<Coordinate> {

    private LineSegment internal_buf;
    private double internal_buf_len;
    private LineStringIterator iter;
    private double step;
    private double length_buf;
    private boolean finished;
    private double pos_begin;
    private double pos_end;

    public LineStringInterpolatedPointIterator(LineString ls, double max_length, double offset) {
        double len = ls.getLength();
        int segments_num = (int) Math.ceil(len / max_length);

        this.step = len/ segments_num;
        this.internal_buf = new LineSegment();
        this.iter = new LineStringIterator(ls,internal_buf);
        iter.next();
        this.internal_buf_len = internal_buf.getLength();
        length_buf = offset;
        double pos = length_buf/internal_buf_len;
        while (pos >= 1) {
            length_buf -= internal_buf_len;
            if (iter.hasNext()) {
                iter.next();
            } else {
                finished = true;
                break;
            }
            internal_buf_len = internal_buf.getLength();
            pos = length_buf/internal_buf_len;
        }
        finished = false;
    }

    public Coordinate getNextCoordinate(Coordinate buf) {
        double pos = length_buf/internal_buf_len;
        while (pos >= 1) {
            length_buf-=internal_buf_len;
            if (iter.hasNext()) {
                iter.next();
            } else {
                pos = 1;
                finished = true;
                break;
            }
            internal_buf_len = internal_buf.getLength();
            pos = length_buf/internal_buf_len;
        };
        buf.x = internal_buf.p0.x*(1-pos)+internal_buf.p1.x*pos;
        buf.y = internal_buf.p0.y*(1-pos)+internal_buf.p1.y*pos;
        length_buf+=step;
        return buf;
    }


    @Override
    public boolean hasNext() {
        return !finished;
    }

    @Override
    public Coordinate next() {
        return new Coordinate( getNextCoordinate(new Coordinate()) );
    };
}
