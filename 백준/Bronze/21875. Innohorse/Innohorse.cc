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

    std::string A, B;
    std::cin >> A >> B;

    int x1 = A[0] - 'a';
    int y1 = A[1] - '1';

    int x2 = B[0] - 'a';
    int y2 = B[1] - '1';

    int dx = abs(x1 - x2);
    int dy = abs(y1 - y2);

    int x = std::min(dx, dy);
    int y = std::max(dx, dy);

    std::cout << x << " " << y << '\n';

}

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    solve();
    return 0;
}