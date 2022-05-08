// Generated by view binder compiler. Do not edit!
package com.simcoder.uber.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.simcoder.uber.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemMarkerBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView duration;

  @NonNull
  public final TextView location;

  @NonNull
  public final LinearLayout locationMarker;

  private ItemMarkerBinding(@NonNull LinearLayout rootView, @NonNull TextView duration,
      @NonNull TextView location, @NonNull LinearLayout locationMarker) {
    this.rootView = rootView;
    this.duration = duration;
    this.location = location;
    this.locationMarker = locationMarker;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemMarkerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemMarkerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_marker, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemMarkerBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.duration;
      TextView duration = rootView.findViewById(id);
      if (duration == null) {
        break missingId;
      }

      id = R.id.location;
      TextView location = rootView.findViewById(id);
      if (location == null) {
        break missingId;
      }

      LinearLayout locationMarker = (LinearLayout) rootView;

      return new ItemMarkerBinding((LinearLayout) rootView, duration, location, locationMarker);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
