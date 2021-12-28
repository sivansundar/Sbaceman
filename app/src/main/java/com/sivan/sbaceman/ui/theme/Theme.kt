package com.sivan.sbaceman.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.os.BuildCompat

@Composable
fun SbacemanTheme(
	isDark: Boolean = isSystemInDarkTheme(),
	dynamic: Boolean = BuildCompat.isAtLeastS(),
	content: @Composable() () -> Unit
) {
	val colors = when {
		dynamic && isDark -> dynamicDarkColorScheme(LocalContext.current)
		dynamic && !isDark -> dynamicLightColorScheme(LocalContext.current)
		isDark -> DarkThemeColors
		else -> LightThemeColors
	}

	androidx.compose.material.MaterialTheme(
		colors = if (isDark) {
			DarkMD2Colors
		} else {
			LightMD2Colors
		}
	) {
		MaterialTheme(
			colorScheme = colors,
			typography = AppTypography,
			content = content
		)
	}
}