inherit rockchip-base-image

IMAGE_FEATURES:append = " debug-tweaks x11-base"
DISTRO_FEATURES:append = " systemd"
DISTRO_FEATURES:remove = " wayland"
