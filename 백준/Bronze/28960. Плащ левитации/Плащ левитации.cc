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

    int h, l, a, b;
    std::cin >> h >> l >> a >> b;

    bool ok = false;

    // case 1: a is on rope
    if (a <= l && b <= 2 * h) ok = true;

    // case 2: b is on rope
    if (b <= l && a <= 2 * h) ok = true;

    std::cout << (ok ? "YES" : "NO") << '\n';

}

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    solve();
    return 0;
}