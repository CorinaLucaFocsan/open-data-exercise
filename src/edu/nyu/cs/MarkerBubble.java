package edu.nyu.cs;

import processing.core.PApplet;
// used by marker
import processing.core.PConstants;
import processing.core.PGraphics;
// import processing.core.PImage;
import de.fhpotsdam.unfolding.marker.AbstractMarker;
import de.fhpotsdam.unfolding.geo.Location;


public class MarkerBubble extends AbstractMarker {
    App app;
    float width;
    float height;
    float[] fillColor;
    public static final float[] DEFAULT_FILL = {255, 0, 0, 127f}; // r, g, b, alpha

    public MarkerBubble(App app, Location location, float radius) {
        this(app, location, radius, DEFAULT_FILL);
    }

    public MarkerBubble(App app, Location location, float radius, float[] fillColor) {
        super(location);
        this.app = app;
        this.width = 2*radius;
        this.height = 2*radius;
        this.fillColor = fillColor;
    }

    @Override
    public void draw(PGraphics pg, float x, float y) {
        float zoom = this.app.map.getZoomLevel();
        // draw into PApplet proportional to zoom level
        pg.pushStyle();
		pg.noStroke(); // no outline around bubbles
        pg.ellipseMode(PConstants.CENTER); // draw emanating from center point
        pg.fill(this.fillColor[0], this.fillColor[1], this.fillColor[2], this.fillColor[3]);
        pg.ellipse(x, y, zoom*this.width, zoom*this.height);
        pg.popStyle();
    }

    @Override
    protected boolean isInside(float checkX, float checkY, float x, float y) {
        return checkX > x && checkX < x + this.width && checkY > y && checkY < y + this.height;
    }

} // MarkerBubble
