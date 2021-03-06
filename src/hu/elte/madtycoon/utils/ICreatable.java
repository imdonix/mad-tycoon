package hu.elte.madtycoon.utils;

import hu.elte.madtycoon.core.World;
import hu.elte.madtycoon.objects.Building;

@FunctionalInterface
public interface ICreatable
{
    Building Create(World world, Vector2F position);
}
