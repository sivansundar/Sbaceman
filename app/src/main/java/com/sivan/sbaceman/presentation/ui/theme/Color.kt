package com.sivan.sbaceman.presentation.ui.theme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val md_theme_light_primary = Color(0xFF4b53bc)
val md_theme_light_onPrimary = Color(0xFFffffff)
val md_theme_light_primaryContainer = Color(0xFFdfe0ff)
val md_theme_light_onPrimaryContainer = Color(0xFF00006f)
val md_theme_light_secondary = Color(0xFF5c5d72)
val md_theme_light_onSecondary = Color(0xFFffffff)
val md_theme_light_secondaryContainer = Color(0xFFe1e0fa)
val md_theme_light_onSecondaryContainer = Color(0xFF191a2c)
val md_theme_light_tertiary = Color(0xFF78536b)
val md_theme_light_onTertiary = Color(0xFFffffff)
val md_theme_light_tertiaryContainer = Color(0xFFffd7ef)
val md_theme_light_onTertiaryContainer = Color(0xFF2e1126)
val md_theme_light_error = Color(0xFFba1b1b)
val md_theme_light_errorContainer = Color(0xFFffdad4)
val md_theme_light_onError = Color(0xFFffffff)
val md_theme_light_onErrorContainer = Color(0xFF410001)
val md_theme_light_background = Color(0xFFfffbff)
val md_theme_light_onBackground = Color(0xFF1b1b1f)
val md_theme_light_surface = Color(0xFFfffbff)
val md_theme_light_onSurface = Color(0xFF1b1b1f)
val md_theme_light_surfaceVariant = Color(0xFFe3e1ec)
val md_theme_light_onSurfaceVariant = Color(0xFF46464f)
val md_theme_light_outline = Color(0xFF77767f)
val md_theme_light_inverseOnSurface = Color(0xFFf3f0f5)
val md_theme_light_inverseSurface = Color(0xFF313034)

val md_theme_dark_primary = Color(0xFFbdc2ff)
val md_theme_dark_onPrimary = Color(0xFF171e8d)
val md_theme_dark_primaryContainer = Color(0xFF3139a3)
val md_theme_dark_onPrimaryContainer = Color(0xFFdfe0ff)
val md_theme_dark_secondary = Color(0xFFc5c4dc)
val md_theme_dark_onSecondary = Color(0xFF2e2f42)
val md_theme_dark_secondaryContainer = Color(0xFF444559)
val md_theme_dark_onSecondaryContainer = Color(0xFFe1e0fa)
val md_theme_dark_tertiary = Color(0xFFe8b9d5)
val md_theme_dark_onTertiary = Color(0xFF46263c)
val md_theme_dark_tertiaryContainer = Color(0xFF5e3c52)
val md_theme_dark_onTertiaryContainer = Color(0xFFffd7ef)
val md_theme_dark_error = Color(0xFFffb4a9)
val md_theme_dark_errorContainer = Color(0xFF930006)
val md_theme_dark_onError = Color(0xFF680003)
val md_theme_dark_onErrorContainer = Color(0xFFffdad4)
val md_theme_dark_background = Color(0xFF1b1b1f)
val md_theme_dark_onBackground = Color(0xFFe4e1e6)
val md_theme_dark_surface = Color(0xFF1b1b1f)
val md_theme_dark_onSurface = Color(0xFFe4e1e6)
val md_theme_dark_surfaceVariant = Color(0xFF46464f)
val md_theme_dark_onSurfaceVariant = Color(0xFFc7c5d0)
val md_theme_dark_outline = Color(0xFF91909a)
val md_theme_dark_inverseOnSurface = Color(0xFF1b1b1f)
val md_theme_dark_inverseSurface = Color(0xFFe4e1e6)

val seed = Color(0xFF3d45ae)
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
