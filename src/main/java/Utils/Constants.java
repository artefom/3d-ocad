package Utils;

import javafx.scene.paint.Color;

/**
 * Created by Artyom.Fomenko on 19.07.2016.
 */
public class Constants {


    //Edges
    public static final double EDGE_WITHIN_THRESHOLD = 1;
    public static final double EDGE_CONCAVE_THRESHOLD = 10;

    //Connections
    public static final double CONNECTIONS_MIN_ANGLE_DEG=10;
    public static final double CONNECTIONS_MAX_ANGLE_DEG=100;
    public static final double CONNECTIONS_WELD_DIST = 0.5;
    public static final double CONNECTIONS_MAX_DIST = 12;
    public static final double CONNECTIONS_NEAR_STEEP_THRESHOLD = 0.5;
    // Don't count intersections within this offset from edges
    public static final double CONNECTIONS_INTERSECTION_OFFSET = 0.1;

    //DRAWING
    public static final double DRAWING_LINE_WIDTH = 0.2;
    public static final double DRAWING_POINT_WIDTH = 0.8;
    public static final boolean DRAWING_INTERPOLATION = false;
    public static final double DRAWING_INTERPOLATION_STEP = 0.2;

    //COLORS
    public static final Color DRAWING_COLOR_EGDE_TO_EDGE = Color.GREEN;
    public static final Color DRAWING_COLOR_ISOLINE_CLOSED = Color.GREEN;
    public static final Color DRAWING_COLOR_CONCAVEHULL = Color.GRAY;
    public static final Color DRAWING_COLOR_ISOLINE = Color.BLACK;
    public static final Color DRAWING_COLOR_SLOPE_DETECTED = Color.BLACK;
    public static final Color DRAWING_COLOR_SLOPE_ORIGINAL = Color.BLUE;

    //Map parsing
    public static final int[] isoline_ids = new int[] {1,2,3};
    public static final int[] slope_ids = new int[] {1,2,3};
    public static final double slope_near_dist = 0.2;
    public static final double slope_length = 1;
    public static final double tangent_precision = 0.6;
    public static final double map_scale_factor = 1600;

    //Nearby detection
    public static final double NEARBY_TRACE_STEP = 2;
    public static final double NEARBY_TRACE_LENGTH=10;
    public static final double NEARBY_TRACE_OFFSET = 0.01;
}
