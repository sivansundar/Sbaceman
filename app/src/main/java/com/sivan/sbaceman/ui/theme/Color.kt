package com.sivan.sbaceman.ui.theme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val md_theme_light_primary = Color(0xFFad3300)
val md_theme_light_onPrimary = Color(0xFFffffff)
val md_theme_light_primaryContainer = Color(0xFFffdbce)
val md_theme_light_onPrimaryContainer = Color(0xFF3a0b00)
val md_theme_light_secondary = Color(0xFF77574c)
val md_theme_light_onSecondary = Color(0xFFffffff)
val md_theme_light_secondaryContainer = Color(0xFFffdbce)
val md_theme_light_onSecondaryContainer = Color(0xFF2c160e)
val md_theme_light_tertiary = Color(0xFF6a5e2f)
val md_theme_light_onTertiary = Color(0xFFffffff)
val md_theme_light_tertiaryContainer = Color(0xFFf3e2a7)
val md_theme_light_onTertiaryContainer = Color(0xFF231b00)
val md_theme_light_error = Color(0xFFba1b1b)
val md_theme_light_errorContainer = Color(0xFFffdad4)
val md_theme_light_onError = Color(0xFFffffff)
val md_theme_light_onErrorContainer = Color(0xFF410001)
val md_theme_light_background = Color(0xFFfcfcfc)
val md_theme_light_onBackground = Color(0xFF211a18)
val md_theme_light_surface = Color(0xFFfcfcfc)
val md_theme_light_onSurface = Color(0xFF211a18)
val md_theme_light_surfaceVariant = Color(0xFFf5ded7)
val md_theme_light_onSurfaceVariant = Color(0xFF53433f)
val md_theme_light_outline = Color(0xFF85736e)
val md_theme_light_inverseOnSurface = Color(0xFFfceeea)
val md_theme_light_inverseSurface = Color(0xFF362f2d)

val md_theme_dark_primary = Color(0xFFffb59b)
val md_theme_dark_onPrimary = Color(0xFF5d1700)
val md_theme_dark_primaryContainer = Color(0xFF852500)
val md_theme_dark_onPrimaryContainer = Color(0xFFffdbce)
val md_theme_dark_secondary = Color(0xFFe7bdb0)
val md_theme_dark_onSecondary = Color(0xFF442a21)
val md_theme_dark_secondaryContainer = Color(0xFF5d4036)
val md_theme_dark_onSecondaryContainer = Color(0xFFffdbce)
val md_theme_dark_tertiary = Color(0xFFd6c68d)
val md_theme_dark_onTertiary = Color(0xFF3a3005)
val md_theme_dark_tertiaryContainer = Color(0xFF51461a)
val md_theme_dark_onTertiaryContainer = Color(0xFFf3e2a7)
val md_theme_dark_error = Color(0xFFffb4a9)
val md_theme_dark_errorContainer = Color(0xFF930006)
val md_theme_dark_onError = Color(0xFF680003)
val md_theme_dark_onErrorContainer = Color(0xFFffdad4)
val md_theme_dark_background = Color(0xFF211a18)
val md_theme_dark_onBackground = Color(0xFFede0dc)
val md_theme_dark_surface = Color(0xFF211a18)
val md_theme_dark_onSurface = Color(0xFFede0dc)
val md_theme_dark_surfaceVariant = Color(0xFF53433f)
val md_theme_dark_onSurfaceVariant = Color(0xFFd8c2bb)
val md_theme_dark_outline = Color(0xFFa08c86)
val md_theme_dark_inverseOnSurface = Color(0xFF211a18)
val md_theme_dark_inverseSurface = Color(0xFFede0dc)

val seed = Color(0xFFd0460b)
val error = Color(0xFFba1b1b)

val LightThemeColors = lightColorScheme(

    primary = md_theme_light_primary,
    onPrimary = md_theme_light_onPrimary,
    primaryContainer = md_theme_light_primaryContainer,
    onPrimaryContainer = md_theme_light_onPrimaryContainer,
    secondary = md_theme_light_secondary,
    onSecondary = md_theme_light_onSecondary,
    secondaryContainer = md_theme_light_secondaryContainer,
    onSecondaryContainer = md_theme_light_onSecondaryContainer,
    tertiary = md_theme_light_tertiary,
    onTertiary = md_theme_light_onTertiary,
    tertiaryContainer = md_theme_light_tertiaryContainer,
    onTertiaryContainer = md_theme_light_onTertiaryContainer,
    error = md_theme_light_error,
    errorContainer = md_theme_light_errorContainer,
    onError = md_theme_light_onError,
    onErrorContainer = md_theme_light_onErrorContainer,
    background = md_theme_light_background,
    onBackground = md_theme_light_onBackground,
    surface = md_theme_light_surface,
    onSurface = md_theme_light_onSurface,
    surfaceVariant = md_theme_light_surfaceVariant,
    onSurfaceVariant = md_theme_light_onSurfaceVariant,
    outline = md_theme_light_outline,
    inverseOnSurface = md_theme_light_inverseOnSurface,
    inverseSurface = md_theme_light_inverseSurface,
)
val DarkThemeColors = darkColorScheme(

    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    primaryContainer = md_theme_dark_primaryContainer,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer,
    secondary = md_theme_dark_secondary,
    onSecondary = md_theme_dark_onSecondary,
    secondaryContainer = md_theme_dark_secondaryContainer,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer,
    tertiary = md_theme_dark_tertiary,
    onTertiary = md_theme_dark_onTertiary,
    tertiaryContainer = md_theme_dark_tertiaryContainer,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer,
    error = md_theme_dark_error,
    errorContainer = md_theme_dark_errorContainer,
    onError = md_theme_dark_onError,
    onErrorContainer = md_theme_dark_onErrorContainer,
    background = md_theme_dark_background,
    onBackground = md_theme_dark_onBackground,
    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface,
    surfaceVariant = md_theme_dark_surfaceVariant,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant,
    outline = md_theme_dark_outline,
    inverseOnSurface = md_theme_dark_inverseOnSurface,
    inverseSurface = md_theme_dark_inverseSurface,
)

val DarkMD2Colors = darkColors(
    primary = DarkThemeColors.primary,
    secondary = DarkThemeColors.secondary,
    background = DarkThemeColors.background,
    surface = DarkThemeColors.surface,
    error = DarkThemeColors.error,
    onPrimary = DarkThemeColors.onPrimary,
    onSecondary = DarkThemeColors.onSecondary,
    onBackground = DarkThemeColors.onBackground,
    onSurface = DarkThemeColors.onSurface,
    onError = DarkThemeColors.onError,
)

val LightMD2Colors = lightColors(
    primary = LightThemeColors.primary,
    secondary = LightThemeColors.secondary,
    background = LightThemeColors.background,
    surface = LightThemeColors.surface,
    error = LightThemeColors.error,
    onPrimary = LightThemeColors.onPrimary,
    onSecondary = LightThemeColors.onSecondary,
    onBackground = LightThemeColors.onBackground,
    onSurface = LightThemeColors.onSurface,
    onError = LightThemeColors.onError,
)
