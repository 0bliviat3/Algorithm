#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>
#include <unordered_map>

void solve() {
    int w, l, h;
    std::cin >> w >> l >> h;

    int mn = std::min(w, l);
    int mx = std::max(w, l);

    if (mn >= 2 * h && mx <= 2 * mn)
        std::cout << "good";
    else
        std::cout << "bad";
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}