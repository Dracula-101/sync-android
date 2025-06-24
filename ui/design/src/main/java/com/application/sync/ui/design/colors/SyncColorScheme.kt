package com.application.sync.ui.design.colors


/**
 * Represents a complete color scheme for an application theme.
 *
 * This data class encapsulates all the primary color categories used throughout
 * the application, providing a centralized way to manage and access theme colors.
 * Each color category contains multiple color variants and shades for different
 * UI states and contexts.
 *
 * @property primary Primary brand colors used for key UI elements like buttons,
 *                   floating action buttons, and active states
 * @property secondary Secondary colors used for less prominent UI elements,
 *                     providing visual hierarchy and accent colors
 * @property background Background colors for different surfaces and containers,
 *                      including main background and elevated surfaces
 * @property surface Surface colors for cards, sheets, and other elevated components
 *                   that sit above the background
 * @property error Error state colors used for validation messages, alerts,
 *                 and destructive actions
 * @property outline Outline colors used for borders, dividers, and component
 *                   boundaries to define visual separation
 * @property scrim Scrim colors used for overlays, modals, and dim effects
 *                 that appear over other content
 * @property inverse Inverse colors used when content needs to stand out against
 *                   the primary color scheme, typically for high contrast scenarios
 */
data class SyncColorScheme(
    val primary: PrimaryColors,
    val secondary: SecondaryColors,
    val background: BackgroundColors,
    val surface: SurfaceColors,
    val error: ErrorColors,
    val outline: OutlineColors,
    val scrim: ScrimColors,
    val inverse: InverseColors,
)