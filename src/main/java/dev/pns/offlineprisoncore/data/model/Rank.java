package dev.pns.offlineprisoncore.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class Rank {
    private String name;
    private String prefix;

    private ArrayList<String> permissions;
}
