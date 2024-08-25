package com.wellness360.users.app.settings.dtos;

public record SettingsReturnDTO(
  int theme,
  int two_factor_auth,
  int notifications,
  int email_notifications
) {
}
